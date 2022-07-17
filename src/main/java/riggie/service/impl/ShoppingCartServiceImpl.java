package riggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import riggie.entity.ShoppingCart;
import riggie.mapper.ShoppingCartMapper;
import riggie.service.ShoppingCartService;

/**
 * @Description:
 * @Author: LLY
 * @Date: 2022/7/15 11:08
 */
@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart> implements ShoppingCartService {
}
