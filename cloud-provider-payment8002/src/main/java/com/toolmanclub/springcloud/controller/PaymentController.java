package com.toolmanclub.springcloud.controller;

import com.toolmanclub.springcloud.entities.CommonResult;
import com.toolmanclub.springcloud.entities.Payment;
import com.toolmanclub.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 订单 Controller
 *
 * @author Yujie Wang
 * @date 2020/7/8 2:26
 */
@Slf4j
@RestController
@RequestMapping("payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/save")
    public CommonResult<Integer> save(@RequestBody Payment payment) {
        int result = paymentService.save(payment);
        log.info("*****插入结果:" + result + ";serverPort:" + serverPort);
        if (result == 1) {
            return new CommonResult<>(200, "插入数据库成功", result);
        } else {
            return new CommonResult<>(444, "插入数据库失败", null);
        }
    }

    @GetMapping(value = "/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****查询结果:" + payment + ";serverPort:" + serverPort);
        if (payment != null) {
            return new CommonResult<>(200, "查询成功;serverPort:" + serverPort, payment);
        } else {
            return new CommonResult<>(444, "没有对应记录,查询id: " + id, null);
        }
    }

    @GetMapping("/lb")
    public String getPaymentLb() {
        return serverPort;
    }
}
