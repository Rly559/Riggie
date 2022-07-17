package riggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import riggie.entity.DishFlavor;
import riggie.mapper.DishFlavorMapper;
import riggie.service.DishFlavorService;

/**
 * @Description:
 * @Author: LLY
 * @Date: 2022/7/13 11:11
 */
@Service
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorMapper, DishFlavor> implements DishFlavorService {
}
