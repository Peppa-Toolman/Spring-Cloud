package com.toolmanclub.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

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
}
