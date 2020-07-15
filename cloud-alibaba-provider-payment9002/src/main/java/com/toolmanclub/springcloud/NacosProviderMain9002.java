package com.toolmanclub.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Yujie Wang
 * @date 2020/7/14 1:29
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosProviderMain9002 {

    public static void main(String[] args) {

        SpringApplication.run(NacosProviderMain9002.class, args);
    }
}
