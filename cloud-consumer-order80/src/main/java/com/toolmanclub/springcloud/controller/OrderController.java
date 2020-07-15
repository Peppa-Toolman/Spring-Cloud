package com.toolmanclub.springcloud.controller;

import cn.hutool.Hutool;
import com.toolmanclub.springcloud.entities.CommonResult;
import com.toolmanclub.springcloud.entities.Payment;
import com.toolmanclub.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author Yujie Wang
 * @date 2020/7/8 10:04
 */
@RequestMapping("consumer")
@RestController
@Slf4j
public class OrderController {

    // public static final String PAYMENT_URI = "http://localhost:8001";
    public static final String PAYMENT_URI     = "http://CLOUD-PAYMENT-SERVICE";
    public static final String PAYMENT_SERVICE = "CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/lb")
    public String getPaymentLn() {
        List<ServiceInstance> instances = discoveryClient.getInstances(PAYMENT_SERVICE);
        if (instances == null || instances.size() <= 0) {
            return "服务未发现";
        }
        ServiceInstance serviceInstance = loadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri + "/payment/lb", String.class);
    }


    @GetMapping("/payment/save")
    public CommonResult save(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URI + "/payment/save", payment, CommonResult.class);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URI + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping("/payment/getEntity/{id}")
    public CommonResult getPaymentById2(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URI + "/payment/get/" + id, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        } else {
            return new CommonResult<>(444, "操作失败");
        }
    }

    @GetMapping("/payment/zipkin")
    public String paymentZipkin() {
        return restTemplate.getForObject("http://localhost:8001" + "/payment/zipkin/", String.class);
    }
}
