package com.lanye.springcloud.service;

import com.lanye.springcloud.entity.CommonResult;
import com.lanye.springcloud.entity.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentService
{
    @Override
    public CommonResult<Payment> paymentSQL(Long id)
    {
        return CommonResult.fail("服务降级返回,---PaymentFallbackService",new Payment(id,"errorSerial"));
    }
}
