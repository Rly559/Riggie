package riggie.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import riggie.common.R;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

/**
 * @Description:
 * @Author: LLY
 * @Date: 2022/7/13 9:29
 *
 * 文件的上传和下载
 */

@RestController
@RequestMapping("/common")
public class CommonController {

    @Value("${reggie.path}")
    private String basePath;

    @PostMapping("/upload")
    public R<String> upload (MultipartFile file){

        //原始文件名
        String originalFilename = file.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));

        //随机生成文件名,防止文件名称重复
        String filename = UUID.randomUUID().toString();
        filename = filename + suffix;

        File dir = new File(basePath);

        //判断目录是否存在
        if(!dir.exists()){
            //不存在，创建目录
            dir.mkdir();
        }

        try {
            file.transferTo(new File(basePath + filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.success(filename);
    }

    @GetMapping("/download")
    public void download(String name, HttpServletResponse response){

        try {
            //输入流 通过输入流读取文件内容
            FileInputStream fis = new FileInputStream(new File(basePath + name));
            //输出流 通过输出流将文件写回浏览器 在浏览器展示图片
            ServletOutputStream os = response.getOutputStream();

            int len = 0;
            byte[] bytes = new byte[1024];
            while((len = fis.read(bytes)) != -1){
                os.write(bytes,0,len);
                os.flush();
            }
            os.close();
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
