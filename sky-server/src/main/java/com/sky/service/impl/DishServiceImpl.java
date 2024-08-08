package com.sky.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sky.constant.MessageConstant;
import com.sky.constant.StatusConstant;
import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.entity.DishFlavor;
import com.sky.exception.DeletionNotAllowedException;
import com.sky.mapper.DishFlavorMapper;
import com.sky.mapper.DishMapper;
import com.sky.mapper.SetmealDishMapper;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.DishService;
import com.sky.vo.DishVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.awt.image.RescaleOp;
import java.util.List;

/**
 * @Author: Y-peak
 * @Date: 2024/8/7 15:43 星期三
 * @ProductName: IntelliJ IDEA
 * @ProjectName: sky-take-out
 * @ClassName: DishServiceImpl
 * @Description:
 */
@Service
public class DishServiceImpl implements DishService {

    @Autowired
    private DishMapper dishMapper;
    @Autowired
    private DishFlavorMapper dishFlavorMapper;
    @Autowired
    private SetmealDishMapper setmealDishMapper;

    /**
     * 新增菜品
     * @param dishDTO
     * @return
     */
    @Transactional
    public void addDishWithFlavor(DishDTO dishDTO) {
        Dish dish = new Dish();
        BeanUtils.copyProperties(dishDTO,dish);
        dishMapper.insert(dish);

        Long dishId = dish.getId();
        List<DishFlavor> falvors = dishDTO.getFlavors();
        if(falvors != null && falvors.size() > 0){
            falvors.forEach(e->{
                e.setDishId(dishId);
            });
            dishFlavorMapper.insertBatch(falvors);
        }
    }

    /**
     * 菜品分页查询
     * @param dishPageQueryDTO
     * @return
     */
    public PageResult pageQuery(DishPageQueryDTO dishPageQueryDTO) {
        PageHelper.startPage(dishPageQueryDTO.getPage(),dishPageQueryDTO.getPageSize());
        Page<DishVO> page = dishMapper.pageQuery(dishPageQueryDTO);
        return new PageResult(page.getTotal(),page.getResult());
    }

    /**
     * 菜品批量删除
     * @param ids
     * @return
     */
    @Transactional
    public void deleteBatch(List<Long> ids) {
        //当前菜品是否能够删除(不能删除起售中的菜品)
        for(Long id : ids){
            Dish dish = dishMapper.getById(id);
            if(dish.getStatus() == StatusConstant.ENABLE){
                throw new DeletionNotAllowedException(MessageConstant.DISH_ON_SALE);
            }
        }

        //当前菜品是否被套餐关联(不能删除套餐内的菜品)
        List<Long> setmealIds = setmealDishMapper.getSetmealIdsByDishIds(ids);
        if(setmealIds != null && setmealIds.size() > 0){
            throw new DeletionNotAllowedException(MessageConstant.DISH_BE_RELATED_BY_SETMEAL);
        }


        //删除菜品信息
        dishMapper.deleteByIds(ids);
        //删除菜品关联的口味数据
        dishFlavorMapper.deleteByDishIds(ids);
    }

    /**
     * 根据id查询菜品信息以及对应口味
     * @param id
     * @return
     */
    public DishVO getDishByIdWithFlavor(Long id) {
        Dish dish = dishMapper.getById(id);
        List<DishFlavor> flavors = dishFlavorMapper.getByDishId(id);
        DishVO dishVO = new DishVO();
        BeanUtils.copyProperties(dish,dishVO);
        dishVO.setFlavors(flavors);
        return dishVO;
    }

    /**
     * 修改菜品信息及其口味
     * @param dishDTO
     */

    @Transactional
    public void updateDishWithFlavor(DishDTO dishDTO) {
        Dish dish = new Dish();
        BeanUtils.copyProperties(dishDTO,dish);
        dishMapper.update(dish);

        //将原本的口味信息删除
        Long dishId = dish.getId();
        dishFlavorMapper.deleteByDishId(dishId);

        List<DishFlavor> falvors = dishDTO.getFlavors();
        if(falvors != null && falvors.size() > 0){
            falvors.forEach(e->{
                e.setDishId(dishId);
            });
            dishFlavorMapper.insertBatch(falvors);
        }
    }
}
