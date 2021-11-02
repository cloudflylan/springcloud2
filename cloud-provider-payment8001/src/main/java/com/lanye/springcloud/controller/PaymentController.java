package com.lanye.springcloud.controller;

import com.lanye.springcloud.entity.CommonResult;
import com.lanye.springcloud.entity.Payment;
import com.lanye.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("payment")
@Slf4j
public class PaymentController
{
    @Value("${server.port}")
    private String serverPort;
    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/get/{id}")
    public CommonResult getById(@PathVariable("id") Integer id)
    {
        Payment payment = paymentService.selectById(id);
        return CommonResult.success(payment);
    }

    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody Payment payment)
    {
        int result = paymentService.add(payment);
        log.info("*****插入结果："+result);
        if (result == 0)
        {  //失败
            return CommonResult.fail("插入数据库失败");
        }
        return CommonResult.success();
    }
    @GetMapping(value = "/lb")
    public String getPaymentLB(){
        return serverPort;
    }
    @GetMapping(value = "/feign/timeout")
    public String paymentFeignTimeout(){
        try { TimeUnit.SECONDS.sleep(3); }catch (Exception e) {e.printStackTrace();}
        return serverPort;
    }
    @GetMapping("/zipkin")
    public String paymentZipkin()
    {
        return "hi ,i'am paymentzipkin server fall back，welcome to atguigu，O(∩_∩)O哈哈~";
    }
}
