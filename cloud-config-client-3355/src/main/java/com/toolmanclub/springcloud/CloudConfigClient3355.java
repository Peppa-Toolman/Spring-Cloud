package com.toolmanclub.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Yujie Wang
 * @date 2020/7/12 23:35
 */
@EnableEurekaClient
@SpringBootApplication
public class CloudConfigClient3355 {

    public static void main(String[] args) {

        SpringApplication.run(CloudConfigClient3355.class,args);
    }
}
