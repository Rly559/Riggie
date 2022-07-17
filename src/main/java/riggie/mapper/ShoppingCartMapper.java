package riggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.apache.ibatis.annotations.Mapper;
import riggie.entity.ShoppingCart;

/**
 * @Description:
 * @Author: LLY
 * @Date: 2022/7/15 11:06
 */
@Mapper
public interface ShoppingCartMapper extends BaseMapper<ShoppingCart> {
}
