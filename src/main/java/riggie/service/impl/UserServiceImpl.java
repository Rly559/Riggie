package riggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import riggie.entity.User;
import riggie.mapper.UserMapper;
import riggie.service.UserService;

/**
 * @Description:
 * @Author: LLY
 * @Date: 2022/7/14 16:07
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
