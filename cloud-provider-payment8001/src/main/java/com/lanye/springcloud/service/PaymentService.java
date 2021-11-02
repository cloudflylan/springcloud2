package com.lanye.springcloud.service;

import com.lanye.springcloud.entity.Payment;

public interface PaymentService
{
    Payment selectById(Integer id);

    int add(Payment payment);
}
