package com.toolmanclub.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author Yujie Wang
 * @date 2020/7/9 17:46
 */
public interface LoadBalancer {

    /**
     * 获取所有的实例
     *
     * @param serviceInstances 服务实例
     * @return {@link ServiceInstance}
     */
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
