package com.sky.mapper;

import com.sky.entity.DishFlavor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: Y-peak
 * @Date: 2024/8/7 16:12 星期三
 * @ProductName: IntelliJ IDEA
 * @ProjectName: sky-take-out
 * @ClassName: DishFlavorMapper
 * @Description:
 */
@Mapper
public interface DishFlavorMapper {

    /**
     * 批量插入口味信息
     * @param flavors
     */
    public void insertBatch(List<DishFlavor> flavors);
}
