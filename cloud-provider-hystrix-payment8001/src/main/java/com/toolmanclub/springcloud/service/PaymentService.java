package com.toolmanclub.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author Yujie Wang
 * @date 2020/7/10 16:12
 */
@Service
public class PaymentService {

    /**
     * 正常访问
     */
    public String paymentInfo_OK(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + "paymentInfo_OK,id:" + "id" + "\t" + "测试";
    }

    /**
     * 模拟超时
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",
            commandProperties = {
                    // 设定可容忍的时间
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
            })
    public String paymentInfo_Timeout(Integer id) {
        // 只要是服务不可用,兜底方案都是 paymentInfo_TimeoutHandler
        int timeNumber = 3000;
//        int age = 10 / 0;
        try {
            TimeUnit.MILLISECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:" + Thread.currentThread().getName() + "paymentInfo_Timeout,id:" + "id" + "\t" + "测试" + "耗时" + timeNumber + "毫秒";
    }

    public String paymentInfo_TimeoutHandler(Integer id) {
        // 返回一个温馨提示
        return "线程池:" + Thread.currentThread().getName() + "系统繁忙,请稍后再试,id:" + "id" + "\t" + "handler";
    }

    //================服务熔断

    /**
     * {@link HystrixCommandProperties}
     * 1）hystrix.command.default.circuitBreaker.requestVolumeThreshold
     * 当在配置时间窗口内达到此数量的请求后,才有可能发生熔断，进行短路。默认20个
     * 当请求的次数不到这个数值的时候,即使之前的请求全部发生错误,也不会发生熔断
     * 2）hystrix.command.default.circuitBreaker.sleepWindowInMilliseconds（短路多久以后开始尝试是否恢复，默认5s）
     * 3）hystrix.command.default.circuitBreaker.errorThresholdPercentage（出错百分比阈值，当达到此阈值后，开始短路。默认50%）
     * a当熔断器开启的时候,所有的请求都不会转发,所有的请求全部降级调用fallback方法,发生熔断之后,降级逻辑称为主逻辑
     * b发生熔断超过窗口期后,会释放一个请求,如果这个请求正常返回,则熔断器会关闭,若失败,则继续开启,否则重复ab两步骤
     */
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),// 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")// 失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("********id不能为负数");
        }
        //  IdUtil.simpleUUID() = UUID.randomUUID().toString().replace("-","")
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用方法成功,流水号:" + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
        return "id不能为复数,请稍后再试,id:" + id;
    }
}
