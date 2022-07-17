package riggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import riggie.dto.SetmealDto;
import riggie.entity.Setmeal;

import java.util.List;

/**
 * @Description:
 * @Author: LLY
 * @Date: 2022/7/12 15:49
 */
public interface SetmealService extends IService<Setmeal> {

    //新增套餐
    public void saveWithDish(SetmealDto setmealDto);

    //删除套餐 同时需要删除套餐和菜品的关联数据
    public void removeWithDish(List<Long> ids);

    public void updateWithDish(SetmealDto setmealDto);

    public SetmealDto getByIdWithDishes(Long id);
}
