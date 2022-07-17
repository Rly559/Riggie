package riggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import riggie.entity.Employee;

/**
 * @Description:
 * @Author: LLY
 * @Date: 2022/7/11 16:01
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}
