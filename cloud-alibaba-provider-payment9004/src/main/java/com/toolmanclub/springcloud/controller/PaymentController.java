package com.toolmanclub.springcloud.controller;

import com.toolmanclub.springcloud.entities.CommonResult;
import com.toolmanclub.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author Yujie Wang
 * @date 2020/7/15 14:42
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Integer, Payment> hashMap = new HashMap<>();

    static {
        hashMap.put(1, new Payment(1, "f23ee70f788d4760a5e0b7e9ac6c22c6"));
        hashMap.put(2, new Payment(2, "925717c0378945bc9959ba7192fff83d"));
        hashMap.put(3, new Payment(3, "981b86c8269644ab80b0299877e6c08c"));
    }

    @GetMapping("/paymentSQL/{id}")
    public CommonResult<Payment> paymentSql(@PathVariable("id") Integer id) {
        Payment payment = hashMap.get(id);
        return new CommonResult<>(200, "from mysql,serverPort:" + serverPort, payment);
    }
}

