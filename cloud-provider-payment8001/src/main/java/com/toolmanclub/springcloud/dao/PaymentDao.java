package com.toolmanclub.springcloud.dao;

import com.toolmanclub.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 订单 Dao
 *
 * @author Yujie Wang
 * @date 2020/7/8 2:07
 */
@Mapper
public interface PaymentDao {

    /**
     * 创建订单
     *
     * @param payment 订单
     * @return int
     */
    int save(Payment payment);

    /**
     * 通过id获取订单
     *
     * @param id id
     * @return {@link Payment}
     */
    Payment getPaymentById(@Param("id") Long id);
}
