package riggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import riggie.entity.Employee;
import riggie.mapper.EmployeeMapper;
import riggie.service.EmployeeService;

/**
 * @Description:
 * @Author: LLY
 * @Date: 2022/7/11 16:49
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
}
