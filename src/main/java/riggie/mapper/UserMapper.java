package riggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import riggie.entity.User;

/**
 * @Description:
 * @Author: LLY
 * @Date: 2022/7/14 16:06
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
