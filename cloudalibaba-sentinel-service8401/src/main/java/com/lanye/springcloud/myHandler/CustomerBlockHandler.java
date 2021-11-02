package com.lanye.springcloud.myHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lanye.springcloud.entity.CommonResult;

public class CustomerBlockHandler
{
    public static CommonResult handleException(BlockException exception) {
        return CommonResult.success( "自定义限流处理信息....CustomerBlockHandler");
    }
    public static CommonResult handleException2(BlockException exception) {
        return CommonResult.success( "自定义限流处理信息2....CustomerBlockHandler");
    }
}
