package com.toolmanclub.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author Yujie Wang
 * @date 2020/7/9 12:48
 */
@Slf4j
@RestController
@RequestMapping("payment")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/consul")
    public String paymentConsul() {
        return "springcloud with consul:" + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
