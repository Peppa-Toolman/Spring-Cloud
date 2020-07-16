package com.toolmanclub.springcloud.seata.service;

import com.toolmanclub.springcloud.seata.domain.Order;

/**
 * @author Yujie Wang
 * @date 2020/7/16 1:41
 */
public interface OrderService {

    /**
     * 创建订单
     *
     * @param order 订单
     */
    void createOrder(Order order);
}
