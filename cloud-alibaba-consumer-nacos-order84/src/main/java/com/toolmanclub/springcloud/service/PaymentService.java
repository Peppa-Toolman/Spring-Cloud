package com.toolmanclub.springcloud.service;

import com.toolmanclub.springcloud.entities.CommonResult;
import com.toolmanclub.springcloud.entities.Payment;
import com.toolmanclub.springcloud.service.fallback.PaymentFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Yujie Wang
 * @date 2020/7/15 16:13
 */
@FeignClient(value = "nacos-payment-provider", fallback = PaymentFallbackService.class)
public interface PaymentService {

    @GetMapping(value = "/paymentSQL/{id}")
    CommonResult<Payment> paymentSql(@PathVariable("id") Integer id);
}
