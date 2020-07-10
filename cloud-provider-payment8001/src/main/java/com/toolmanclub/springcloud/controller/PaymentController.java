package com.toolmanclub.springcloud.controller;

import com.toolmanclub.springcloud.entities.CommonResult;
import com.toolmanclub.springcloud.entities.Payment;
import com.toolmanclub.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 订单 Controller
 *
 * @author Yujie Wang
 * @date 2020/7/8 2:26
 */
@Slf4j
@RestController
public class PaymentController {

    private static final String SERVICE_ID = "CLOUD-PAYMENT-SERVICE";

    @Resource
    private PaymentService  paymentService;
    @Value("${server.port}")
    private String          serverPort;
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "payment/save")
    public CommonResult<Integer> save(@RequestBody Payment payment) {
        int result = paymentService.save(payment);
        log.info("*****插入结果:" + result + ";serverPort:" + serverPort);
        if (result == 1) {
            return new CommonResult<>(200, "插入数据库成功", result);
        } else {
            return new CommonResult<>(444, "插入数据库失败", null);
        }
    }

    @GetMapping(value = "payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****查询结果:" + payment + ";serverPort:" + serverPort);
        if (payment != null) {
            return new CommonResult<>(200, "查询成功;serverPort:" + serverPort, payment);
        } else {
            return new CommonResult<>(444, "没有对应记录,查询id: " + id, null);
        }
    }

    @GetMapping("payment/discovery")
    public Object discovery() {
        // 查看所有的服务
        List<String> services = discoveryClient.getServices();
        services.forEach(service -> log.info("****element" + service));
        // 获取所有的实例
        List<ServiceInstance> instances = discoveryClient.getInstances(SERVICE_ID);
        instances.forEach(instance -> log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri()));
        /*
        <EurekaDiscoveryClient>
            <services>
            <services>cloud-payment-service</services>
            <services>cloud-order-service</services>
            </services>
            <order>0</order>
        </EurekaDiscoveryClient>
         */
        return this.discoveryClient;
    }

    @GetMapping("payment/lb")
    public String getPaymentLb() {
        return serverPort;
    }

    @GetMapping("payment/feign/timeout")
    public String paymentFeignTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
