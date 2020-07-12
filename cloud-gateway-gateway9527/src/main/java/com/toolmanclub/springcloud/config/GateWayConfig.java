package com.toolmanclub.springcloud.config;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

/**
 * @author Yujie Wang
 * @date 2020/7/11 22:08
 */
@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        // /guonei映射到http://new.baidu.com/guonei

        routes
                .route(predicateSpec -> predicateSpec.path("/guonei").uri("http://news.baidu.com/guonei"))
                .route(predicateSpec -> predicateSpec.path("/guoji").uri("http://news.baidu.com/guoji"));
        return routes.build();
    }
}
