package com.toolmanclub.springcloud.seata.dao;

import com.toolmanclub.springcloud.seata.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Yujie Wang
 * @date 2020/7/16 1:23
 */
@Mapper
public interface OrderDao {


    /**
     * 新建订单
     *
     * @param order 订单
     */
    void createOrder(Order order);

    /**
     * 更新订单
     *
     * @param status 状态
     * @param userId 用户id
     */
    void updateOrder(@Param("userId") Long userId,
                     @Param("status") Integer status);
}
