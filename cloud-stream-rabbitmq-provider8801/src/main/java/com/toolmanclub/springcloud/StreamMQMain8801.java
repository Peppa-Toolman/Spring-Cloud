package com.toolmanclub.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Yujie Wang
 * @date 2020/7/13 20:06
 */
@EnableEurekaClient
@SpringBootApplication
public class StreamMQMain8801 {

    public static void main(String[] args) {

        SpringApplication.run(StreamMQMain8801.class, args);
    }
}
