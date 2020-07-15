package com.toolmanclub.springcloud.service.fallback;

import com.toolmanclub.springcloud.entities.CommonResult;
import com.toolmanclub.springcloud.entities.Payment;
import com.toolmanclub.springcloud.service.PaymentService;
import org.springframework.stereotype.Component;

/**
 * @author Yujie Wang
 * @date 2020/7/15 16:16
 */
@Component
public class PaymentFallbackService implements PaymentService {

    @Override
    public CommonResult<Payment> paymentSql(Integer id) {
        return new CommonResult<>(444, "服务降级处理", new Payment(id, null));
    }
}
