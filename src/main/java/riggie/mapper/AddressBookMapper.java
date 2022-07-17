package riggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import riggie.entity.AddressBook;

/**
 * @Description:
 * @Author: LLY
 * @Date: 2022/7/15 9:40
 */
@Mapper
public interface AddressBookMapper extends BaseMapper<AddressBook> {
}
