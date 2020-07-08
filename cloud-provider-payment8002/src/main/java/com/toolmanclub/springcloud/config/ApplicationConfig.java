package com.toolmanclub.springcloud.config;

import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置
 *
 * @author Yujie Wang
 * @date 2020/7/8 2:17
 */
@Configuration
public class ApplicationConfig {

    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return configuration -> configuration.setCacheEnabled(true);
    }
}
