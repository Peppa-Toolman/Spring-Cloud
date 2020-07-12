package com.toolmanclub.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Yujie Wang
 * @date 2020/7/11 17:11
 */
@SpringBootApplication
@EnableEurekaClient

public class GateWay9527 {

    public static void main(String[] args) {
        SpringApplication.run(GateWay9527.class, args);
    }
}
