package com.sky.service;

import com.sky.dto.OrdersSubmitDTO;
import com.sky.vo.OrderSubmitVO;

/**
 * @Author: Y-peak
 * @Date: 2024/8/23 19:44 星期五
 * @ProductName: IntelliJ IDEA
 * @ProjectName: sky-take-out
 * @ClassName: OrderService
 * @Description:
 */
public interface OrderService {
    /**
     * 用户下单
     * @param ordersSubmitDTO
     * @return
     */
    OrderSubmitVO submitOrder(OrdersSubmitDTO ordersSubmitDTO);
}
