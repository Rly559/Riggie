package riggie;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Description:
 * @Author: LLY
 * @Date: 2022/7/11 14:08
 */

@SpringBootApplication
@Slf4j
@ServletComponentScan
@EnableTransactionManagement
public class ReggieApplication {
    public static void main(String[] args){
        SpringApplication.run(ReggieApplication.class, args);
        log.info("项目启动成功！");
    }
}
