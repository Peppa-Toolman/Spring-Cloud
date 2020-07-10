package com.toolmanclub.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Yujie Wang
 * @date 2020/7/10 17:05
 */
@EnableFeignClients
@SpringBootApplication
public class OrderHystrixMain80 {

    public static void main(String[] args) {

        SpringApplication.run(OrderHystrixMain80.class, args);
    }
}
