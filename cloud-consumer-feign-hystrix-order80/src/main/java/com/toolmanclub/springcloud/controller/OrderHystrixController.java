package com.toolmanclub.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
// 配置全局通用的fallback兜底方案
@DefaultProperties(defaultFallback = "defaultFallbackMethod")
public class OrderHystrixController {

    @Resource
    private OrderHystrixService paymentHystrixService;

    @GetMapping("consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        return paymentHystrixService.paymentInfo_OK(id);
    }

    @GetMapping("consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
//    })
    @HystrixCommand
    public String paymentInfo_Timeout(@PathVariable("id") Integer id) {
        // int age =10/0;
        return paymentHystrixService.paymentInfo_Timeout(id);
    }

    // 兜底方案
    public String paymentInfo_TimeoutHandler(@PathVariable("id") Integer id) {
        return "consumer:80,系统繁忙,请稍后再试";
    }

    // 全局兜底方案
    public String defaultFallbackMethod() {
        return "全局异常处理";
    }
}
