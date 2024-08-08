package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SetmealDishMapper {

    /**
     * 根据分类id查询套餐的数量
     * @param ids
     * @return
     */

    /**
     * 根据菜品ids查询套餐ids
     * @param ids
     * @return
     */
    List<Long> getSetmealIdsByDishIds(List<Long> ids);

}
