package riggie.dto;

import lombok.Data;
import riggie.entity.OrderDetail;
import riggie.entity.Orders;

import java.util.List;

/**
 * @Description:
 * @Author: LLY
 * @Date: 2022/7/15 16:41
 */
@Data
public class OrderDto extends Orders {
    private List<OrderDetail> orderDetails;
}
