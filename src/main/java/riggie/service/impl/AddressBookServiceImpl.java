package riggie.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import riggie.entity.AddressBook;
import riggie.mapper.AddressBookMapper;
import riggie.service.AddressBookService;

/**
 * @Description:
 * @Author: LLY
 * @Date: 2022/7/15 9:41
 */
@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper,AddressBook> implements AddressBookService {

}
