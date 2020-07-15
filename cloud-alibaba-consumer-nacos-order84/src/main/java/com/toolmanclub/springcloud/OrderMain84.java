package com.toolmanclub.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Yujie Wang
 * @date 2020/7/15 14:58
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class OrderMain84 {

    public static void main(String[] args) {

        SpringApplication.run(OrderMain84.class, args);
    }
}
