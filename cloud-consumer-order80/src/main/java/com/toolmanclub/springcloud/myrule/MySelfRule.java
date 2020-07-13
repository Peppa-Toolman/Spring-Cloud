package com.toolmanclub.springcloud.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义规则
 *
 * @author Yujie Wang
 * @date 2020/7/9 16:26
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule iRule() {
        // 随机
//        return new RandomRule();
        return new RoundRobinRule();
    }
}
