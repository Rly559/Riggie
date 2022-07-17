package riggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import riggie.common.R;
import riggie.entity.Category;
import riggie.service.CategoryService;

import java.util.List;

/**
 * @Description:
 * @Author: LLY
 * @Date: 2022/7/12 12:46
 */

@Slf4j
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //新增菜品分类
    @PostMapping
    public R<String> save(@RequestBody Category category){
        categoryService.save(category);
        return R.success("新增菜品分类成功！");
    }

    //菜品分类信息查询
    @GetMapping("/page")
    public R<Page> page(int page, int pageSize){
        log.info("page = {}" + page + ",pageSize = {}" + pageSize);

        //构造分页构造器
        Page<Category> pageInfo = new Page<>(page,pageSize);
        //构造条件过滤器
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper();

        queryWrapper.orderByAsc(Category::getSort);
        //执行查询
        categoryService.page(pageInfo,queryWrapper);
        return R.success(pageInfo);
    }

    //根据id修改菜品分类信息
    @PutMapping
    public R<String> update(@RequestBody Category category){
        log.info(category.toString());

//        Long empId = (Long) request.getSession().getAttribute("employee");
//        employee.setUpdateTime(LocalDateTime.now());
//        employee.setUpdateUser(empId);
        categoryService.updateById(category);
        return R.success("修改成功！");
    }

    //回显
    @GetMapping("/{id}")
    public R<Category> getById(@PathVariable Long id){
        log.info("根据id查询员工信息");
        Category category = categoryService.getById(id);
        if(category != null){
            return R.success(category);
        }
        return R.error("没有查询到员工信息！");
    }

    @DeleteMapping
    public R<String> delete(Long ids){
        categoryService.remove(ids);
        return R.success("成功删除该菜品分类！");
    }

    //根据条件查询分类数据
    @GetMapping("/list")
    public R<List<Category>> list(Category category){
        //条件构造器
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
        //添加条件
        queryWrapper.eq(category.getType() != null, Category::getType,category.getType());
        //添加排序
        queryWrapper.orderByAsc(Category::getSort).orderByDesc(Category::getUpdateTime);

        List<Category> list = categoryService.list(queryWrapper);
        return R.success(list);
    }
}
