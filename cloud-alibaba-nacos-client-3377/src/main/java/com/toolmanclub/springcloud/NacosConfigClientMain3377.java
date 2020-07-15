package com.toolmanclub.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Yujie Wang
 * @date 2020/7/14 14:41
 */
@EnableDiscoveryClient
@SpringBootApplication
public class NacosConfigClientMain3377 {

    public static void main(String[] args) {

        SpringApplication.run(NacosConfigClientMain3377.class, args);
    }
}
