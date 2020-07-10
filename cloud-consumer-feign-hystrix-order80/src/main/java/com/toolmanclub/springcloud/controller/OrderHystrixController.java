package com.toolmanclub.springcloud.controller;

import com.toolmanclub.springcloud.service.OrderHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Yujie Wang
 * @date 2020/7/10 17:10
 */
@RestController
@Slf4j
public class OrderHystrixController {

    @Resource
    private OrderHystrixService paymentHystrixService;


    @GetMapping("consumer/payment/hystrix/ok/{id}")
    String paymentInfo_OK(@PathVariable("id") Integer id) {
        return paymentHystrixService.paymentInfo_OK(id);
    }


    @GetMapping("consumer/payment/hystrix/timeout/{id}")
    String paymentInfo_Timeout(@PathVariable("id") Integer id) {
        return paymentHystrixService.paymentInfo_Timeout(id);
    }
}
