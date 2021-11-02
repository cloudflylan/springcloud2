package com.lanye.springcloud.service.impl;

import com.lanye.springcloud.dao.PaymentDao;
import com.lanye.springcloud.entity.Payment;
import com.lanye.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService
{
    @Resource
    private PaymentDao paymentDao;
    @Override
    public Payment selectById(Integer id)
    {
        return paymentDao.selectById(id);
    }

    @Override
    public int add(Payment payment)
    {
        return paymentDao.add(payment);
    }
}
