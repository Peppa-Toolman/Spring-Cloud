package com.toolmanclub.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.toolmanclub.springcloud.entities.CommonResult;
import com.toolmanclub.springcloud.entities.Payment;
import com.toolmanclub.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author Yujie Wang
 * @date 2020/7/15 15:00
 */
@RestController
@Slf4j
public class CircleBreakerController {

    @Value("${service-url.nacos-user-service}")
    private String serviceUrl;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/fallback/{id}")
    @SentinelResource(value = "fallback", fallback = "handlerFallback",
            blockHandler = "blockHandler",
            //IllegalArgumentException
            exceptionsToIgnore = {IllegalArgumentException.class})
    public CommonResult<Payment> fallback(@PathVariable("id") Integer id) {

        CommonResult<Payment> result = restTemplate.getForObject(serviceUrl + "/paymentSQL/" + id, CommonResult.class, id);
        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常");
        } else if (result.getData() == null) {
            throw new NullPointerException("NullPointerException,该ID没有对应记录,空指针异常");
        }
        return result;
    }

    public CommonResult<Object> handlerFallback(Integer id, Throwable e) {
        return new CommonResult<>(444, "兜底异常handlerFallback,exception:" + e.getMessage(), new Payment(id, null));
    }

    public CommonResult<Object> blockHandler(Integer id, Exception e) {
        return new CommonResult<>(444, "blockHandler,exception:" + e.getMessage(), new Payment(id, null));
    }

    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/consumer/paymentSQL/{id}")
    CommonResult<Payment> paymentSql(@PathVariable("id") Integer id) {
        return paymentService.paymentSql(id);
    }
}
