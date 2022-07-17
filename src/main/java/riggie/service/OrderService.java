package riggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import riggie.entity.Orders;

/**
 * @Description:
 * @Author: LLY
 * @Date: 2022/7/14 18:31
 */
public interface OrderService extends IService<Orders> {
    public void submit(Orders orders);
}
