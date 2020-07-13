package com.toolmanclub.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Yujie Wang
 * @date 2020/7/13 14:36
 */
@EnableEurekaClient
@SpringBootApplication
public class ConfigClientMain3366 {

    public static void main(String[] args) {

        SpringApplication.run(ConfigClientMain3366.class, args);
    }
}
