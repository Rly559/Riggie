package riggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Controller;
import riggie.entity.Category;
import riggie.entity.Employee;

/**
 * @Description:
 * @Author: LLY
 * @Date: 2022/7/12 14:38
 */

@Mapper
public interface CategoryMapper  extends BaseMapper<Category> {
}
