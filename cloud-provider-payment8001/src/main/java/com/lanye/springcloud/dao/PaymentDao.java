package com.lanye.springcloud.dao;

import com.lanye.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao
{
    Payment selectById(@Param("id") Integer id);

    int add(@Param("payment") Payment payment);
}
