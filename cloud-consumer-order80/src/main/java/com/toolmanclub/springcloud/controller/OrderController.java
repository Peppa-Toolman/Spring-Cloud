package com.toolmanclub.springcloud.controller;

import com.toolmanclub.springcloud.entities.CommonResult;
import com.toolmanclub.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author Yujie Wang
 * @date 2020/7/8 10:04
 */
@RequestMapping("consumer")
@RestController
@Slf4j
public class OrderController {

    public static final String PAYMENT_URI = "http://localhost:8001";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/payment/save")
    public CommonResult save(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URI + "/payment/save", payment, CommonResult.class);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URI + "/payment/get/" + id, CommonResult.class);
    }
}
