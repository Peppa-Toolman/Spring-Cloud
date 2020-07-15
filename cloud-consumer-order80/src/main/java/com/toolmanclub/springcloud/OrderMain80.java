package com.toolmanclub.springcloud;

import com.toolmanclub.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Yujie Wang
 * @date 2020/7/8 9:59
 */
@SpringBootApplication
@EnableEurekaClient
//@RibbonClients(
//        @RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = MySelfRule.class)
//)
public class OrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }
}
