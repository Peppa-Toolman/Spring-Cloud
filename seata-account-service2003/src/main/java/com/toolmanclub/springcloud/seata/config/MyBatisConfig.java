package com.toolmanclub.springcloud.seata.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * 我batis配置
 *
 * @author Yujie Wang
 * @auther zzyy
 * @create 2019-12-11 16:57
 * @date 2020-07-16 15:26
 */
@Configuration
@MapperScan({"com.toolmanclub.springcloud.seata.dao"})
public class MyBatisConfig {
}
