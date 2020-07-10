package com.toolmanclub.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 客户端会遇到的异常
 * 运行;超时;宕机
 *
 * @author Yujie Wang
 * @date 2020/7/10 17:06
 */
// fallback = PaymentFallbackService.class,PaymentFallbackService实现其Service类,在实现类中进行服务降级
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT", fallback = PaymentFallbackService.class)
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
