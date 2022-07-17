package riggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import riggie.entity.Category;

/**
 * @Description:
 * @Author: LLY
 * @Date: 2022/7/12 14:39
 */
public interface CategoryService extends IService<Category> {
    public void remove(Long id);
}
