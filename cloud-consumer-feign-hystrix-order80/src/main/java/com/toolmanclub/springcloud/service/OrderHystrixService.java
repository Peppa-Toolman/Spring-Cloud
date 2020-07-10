package com.toolmanclub.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author Yujie Wang
 * @date 2020/7/10 17:06
 */
@FeignClient("CLOUD-PROVIDER-HYSTRIX-PAYMENT")
public interface OrderHystrixService {

    /**
     * 正常访问
     */
    @GetMapping("payment/hystrix/ok/{id}")
    String paymentInfo_OK(@PathVariable("id") Integer id);

    /**
     * 模拟超时
     */
    @GetMapping("payment/hystrix/timeout/{id}")
    String paymentInfo_Timeout(@PathVariable("id") Integer id);
}
