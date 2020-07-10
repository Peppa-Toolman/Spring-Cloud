package com.toolmanclub.springcloud.service;

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
    public String paymentInfo_Timeout(Integer id) {
        int timeNumber = 3;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:" + Thread.currentThread().getName() + "paymentInfo_Timeout,id:" + "id" + "\t" + "测试" + "耗时" + timeNumber + "秒";
    }

}
