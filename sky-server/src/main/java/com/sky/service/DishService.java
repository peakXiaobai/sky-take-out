package com.sky.service;

import com.sky.dto.DishDTO;

/**
 * @Author: Y-peak
 * @Date: 2024/8/7 15:43 星期三
 * @ProductName: IntelliJ IDEA
 * @ProjectName: sky-take-out
 * @ClassName: DishService
 * @Description:
 */
public interface DishService {

    /**
     * 新增菜品
     * @param dishDTO
     * @return
     */
    void addDishWithFlavor(DishDTO dishDTO);
}
