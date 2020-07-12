package com.toolmaclub.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 所有需要监控的模块都需要增加spring-boot-starter-actuator依赖
 *
 * @author Yujie Wang
 * @date 2020/7/11 2:00
 */
@EnableHystrixDashboard
@SpringBootApplication
public class DashboardMain9001 {

    public static void main(String[] args) {
        SpringApplication.run(DashboardMain9001.class, args);
    }
}
