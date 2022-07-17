package riggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import riggie.common.CustomException;
import riggie.entity.Category;
import riggie.entity.Dish;
import riggie.entity.Setmeal;
import riggie.mapper.CategoryMapper;
import riggie.service.CategoryService;
import riggie.service.DishService;
import riggie.service.SetmealService;

/**
 * @Description:
 * @Author: LLY
 * @Date: 2022/7/12 14:40
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper,Category> implements CategoryService{

    @Autowired
    private DishService dishService;

    @Autowired
    private SetmealService setmealService;
    //根据id删除分类，删除之前进行判断是否存在关联套餐
    @Override
    public void remove(Long id) {
        LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper<>();
        //添加查询条件，根据分类id进行查询
        dishLambdaQueryWrapper.eq(Dish::getCategoryId,id);
        int count = (int) dishService.count(dishLambdaQueryWrapper);
        //查询当前分类是否关联菜品,如果已经关联，抛出一个业务异常
        if(count > 0){
            throw new CustomException("当前分类关联了菜品，不能删除！");
        }

        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper= new LambdaQueryWrapper<>();
        //查询当前分类是否关联套餐，如果已经关联，抛出一个业务异常
        setmealLambdaQueryWrapper.eq(Setmeal::getCategoryId, id);
        int Count = (int) setmealService.count(setmealLambdaQueryWrapper);
        if(Count > 0){
            throw new CustomException("当前分类关联了套餐，不能删除！");
        }
        //正常删除分类
        super.removeById(id);
    }
}
