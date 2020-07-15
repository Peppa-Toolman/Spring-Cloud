package com.toolmanclub.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Yujie Wang
 * @date 2020/7/14 23:09
 */
@EnableDiscoveryClient
@SpringBootApplication
public class MainApp8401 {

    public static void main(String[] args) {

        SpringApplication.run(MainApp8401.class, args);
    }
}
