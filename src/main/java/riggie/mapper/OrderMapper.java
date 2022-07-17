package riggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import riggie.entity.Orders;

/**
 * @Description:
 * @Author: LLY
 * @Date: 2022/7/14 18:30
 */

@Mapper
public interface OrderMapper extends BaseMapper<Orders> {
}
