package com.toolmanclub.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.toolmanclub.springcloud.entities.CommonResult;
import com.toolmanclub.springcloud.entities.Payment;
import com.toolmanclub.springcloud.handler.CustomerBlockHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yujie Wang
 * @date 2020/7/15 13:59
 */
@RestController
@Slf4j
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handlerException")
    public CommonResult<Payment> byResource() {
        return new CommonResult<>(200, "按资源名称限流", new Payment(2020, "serial001"));
    }

    public CommonResult<Object> handlerException(BlockException exception) {
        return new CommonResult<>(444, exception.getClass().getCanonicalName() + "\t" + "服务不可用");
    }

    @GetMapping("/byURl")
    @SentinelResource(value = "byURl")
    public CommonResult<Payment> byUrl() {
        return new CommonResult<>(200, "按url限流", new Payment(2020, "serial002"));
    }

    @GetMapping("/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handleException1")
    public CommonResult<Payment> customerBlockHandler() {
        return new CommonResult<>(200, "按客户自定义方式限流", new Payment(2020, "serial003"));
    }

}
