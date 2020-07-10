package com.toolmanclub.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author Yujie Wang
 * @date 2020/7/10 23:58
 */
@Component
public class PaymentFallbackService implements OrderHystrixService {

    @Override
    public String paymentInfo_OK(Integer id) {
        return "---PaymentFallbackService fallback paymenntInfo_OK";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "---PaymentFallbackService fallback paymentInfo_Timeout";
    }
}
