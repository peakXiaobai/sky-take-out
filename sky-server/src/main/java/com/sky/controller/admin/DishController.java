package com.sky.controller.admin;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.DishService;
import com.sky.vo.DishVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: Y-peak
 * @Date: 2024/8/7 15:40 星期三
 * @ProductName: IntelliJ IDEA
 * @ProjectName: sky-take-out
 * @ClassName: DishController
 * @Description: 菜品管理
 */

@RestController
@RequestMapping("/admin/dish")
@Api(tags = "菜品相关接口")
@Slf4j
public class DishController {

    @Autowired
    DishService dishService;

    /**
     * 新增菜品
     * @param dishDTO
     * @return
     */
    @PostMapping
    @ApiOperation("新增菜品")
    public Result<String> addDish(@RequestBody DishDTO dishDTO){
        log.info("新增菜品: {}",dishDTO);
        dishService.addDishWithFlavor(dishDTO);
        return Result.success();
    }

    /**
     * 菜品分页查询
     * @param dishPageQueryDTO
     * @return
     */
    @GetMapping("/page")
    @ApiOperation("菜品分页查询")
    public Result<PageResult> page(DishPageQueryDTO dishPageQueryDTO) {
        log.info("菜品分页查询: {}",dishPageQueryDTO);
        PageResult pageResult = dishService.pageQuery(dishPageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * 菜品批量删除
     * @param ids
     * @return
     */
    @DeleteMapping
    @ApiOperation("菜品批量删除")
    public Result<String> deleteDish(@RequestParam List<Long> ids){
        log.info("菜品批量删除: {}",ids);
        dishService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 根据id查询菜品信息以及对应口味
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation("根据id查询菜品信息以及对应口味")
    public Result<DishVO> getDishById(@PathVariable Long id){
        log.info("根据id查询菜品信息以及对应口味: {}",id);
        DishVO dishVO = dishService.getDishByIdWithFlavor(id);
        return Result.success(dishVO);
    }

    /**
     * 修改菜品信息及其口味
     * @param dishDTO
     * @return
     */
    @PutMapping
    @ApiOperation("修改菜品")
    public Result<String> updateDish(@RequestBody DishDTO dishDTO){
        log.info("修改菜品: {}",dishDTO);
        dishService.updateDishWithFlavor(dishDTO);
        return Result.success();
    }
}
