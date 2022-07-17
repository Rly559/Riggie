package riggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import riggie.entity.OrderDetail;
import riggie.mapper.OrderDetailMapper;
import riggie.service.OrderDetailService;

import java.util.List;

/**
 * @Description:
 * @Author: LLY
 * @Date: 2022/7/15 15:38
 */
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {
}
