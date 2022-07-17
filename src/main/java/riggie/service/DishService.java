package riggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import riggie.dto.DishDto;
import riggie.entity.Dish;

import java.util.List;

/**
 * @Description:
 * @Author: LLY
 * @Date: 2022/7/12 15:48
 */

public interface DishService extends IService<Dish> {
    public void saveWithFlavor(DishDto dishDto);

    public DishDto getByIdWithFlavor(Long id);

    public void updateWithFlavor(DishDto dishDto);
}
