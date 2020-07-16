package com.toolmanclub.springcloud.seata.controller;

import com.toolmanclub.springcloud.seata.domain.CommonResult;
import com.toolmanclub.springcloud.seata.domain.Order;
import com.toolmanclub.springcloud.seata.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Yujie Wang
 * @date 2020/7/16 1:59
 */
@RequestMapping("order")
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/create")
    public CommonResult<Object> create(Order order) {

        orderService.createOrder(order);
        return new CommonResult<>(200, "订单创建成功");
    }
}
