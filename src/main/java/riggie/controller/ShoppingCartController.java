package riggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import riggie.common.BaseContext;
import riggie.common.R;
import riggie.entity.ShoppingCart;
import riggie.service.ShoppingCartService;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Description:
 * @Author: LLY
 * @Date: 2022/7/15 11:09
 */
@Slf4j
@RestController
@RequestMapping("/shoppingCart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @PostMapping("/add")
    public R<ShoppingCart> add(@RequestBody ShoppingCart shoppingCart){
        //设置用户id 指定当前是哪个用户的购物车数据
        Long currentId = BaseContext.getCurrentId();
        shoppingCart.setUserId(currentId);
        //查询当前或者套餐是否在购物车中
        Long dishId = shoppingCart.getDishId();

        LambdaQueryWrapper<ShoppingCart> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ShoppingCart::getUserId, currentId);
        if(dishId != null){
            //添加的是菜品
            queryWrapper.eq(ShoppingCart::getDishId, dishId);
        }else {
            queryWrapper.eq(ShoppingCart::getSetmealId, shoppingCart.getSetmealId());
        }
        ShoppingCart cartServiceOne =  shoppingCartService.getOne(queryWrapper);

        if(cartServiceOne != null){
            //如果已经存在 在原来数量基础上加一
            Integer number = cartServiceOne.getNumber();
            cartServiceOne.setNumber(number + 1);
            shoppingCartService.updateById(cartServiceOne);
        }else{
            //如果不存在 则添加到购物车 数量默认为一
            shoppingCart.setNumber(1);
            shoppingCart.setCreateTime(LocalDateTime.now());
            shoppingCartService.save(shoppingCart);
            cartServiceOne = shoppingCart;
        }
        return R.success(cartServiceOne);
    }


    //查看购物车
    @GetMapping("/list")
    public R<List<ShoppingCart>> list(){
        LambdaQueryWrapper<ShoppingCart> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(ShoppingCart::getUserId,BaseContext.getCurrentId());
        queryWrapper.orderByAsc(ShoppingCart::getCreateTime);

        List<ShoppingCart> list = shoppingCartService.list(queryWrapper);
        return R.success(list);
    }

    @Transactional
    @PostMapping("/sub")
    public R<ShoppingCart> sub(@RequestBody ShoppingCart shoppingCart){
        Long dishId = shoppingCart.getDishId();
        LambdaQueryWrapper<ShoppingCart> queryWrapper = new LambdaQueryWrapper();
        if(dishId != null){
            queryWrapper.eq(ShoppingCart::getDishId,dishId);
            queryWrapper.eq(ShoppingCart::getUserId,BaseContext.getCurrentId());
            ShoppingCart shoppingCart1 = shoppingCartService.getOne(queryWrapper);
            shoppingCart1.setNumber(shoppingCart1.getNumber() - 1);
            Integer number = shoppingCart1.getNumber();
            if(number > 0){
                shoppingCartService.updateById(shoppingCart1);
            }else if(number == 0){
                shoppingCartService.removeById(shoppingCart1);
            }else if(number < 0){
                return R.error("操作异常！");
            }

            return R.success(shoppingCart1);
        }
        Long setmealId = shoppingCart.getSetmealId();
        LambdaQueryWrapper<ShoppingCart> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if(setmealId != null){
            lambdaQueryWrapper.eq(ShoppingCart::getSetmealId,setmealId);
            lambdaQueryWrapper.eq(ShoppingCart::getUserId,BaseContext.getCurrentId());
            ShoppingCart shoppingCart2 = shoppingCartService.getOne(lambdaQueryWrapper);
            shoppingCart2.setNumber(shoppingCart2.getNumber() - 1);
            Integer number = shoppingCart2.getNumber();
            if(number > 0){
               shoppingCartService.updateById(shoppingCart2);
            }else if(number == 0){
                shoppingCartService.removeById(shoppingCart2);
            }else if(number < 0){
                return R.error("操作异常！");
            }
            return R.success(shoppingCart2);
        }
        return R.error("操作异常！");
    }

    @DeleteMapping("/clean")
    public R<String> clean(){
        LambdaQueryWrapper<ShoppingCart> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(ShoppingCart::getUserId,BaseContext.getCurrentId());

        shoppingCartService.remove(queryWrapper);
        return R.success("清空购物车成功！");
    }
}
