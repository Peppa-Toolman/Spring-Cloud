package com.toolmanclub.springcloud.seata.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * mybatis配置
 *
 * @author Yujie Wang
 * @date 2020-07-16 02:05
 */
@Configuration
@MapperScan({"com.toolmanclub.springcloud.seata.dao"})
public class MyBatisConfig {
}
