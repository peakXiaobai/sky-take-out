package com.sky.mapper;

import com.sky.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: Y-peak
 * @Date: 2024/8/23 19:47 星期五
 * @ProductName: IntelliJ IDEA
 * @ProjectName: sky-take-out
 * @ClassName: OrderMapper
 * @Description:
 */
@Mapper
public interface OrderMapper {
    /**
     * 插入订单数据
     * @param order
     */
    void insert(Orders order);
}
