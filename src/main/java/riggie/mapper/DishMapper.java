package riggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import riggie.entity.Dish;

/**
 * @Description:
 * @Author: LLY
 * @Date: 2022/7/12 15:47
 */

@Mapper
public interface DishMapper extends BaseMapper<Dish> {
}
