package com.lanye.springcloud.test;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

public class SnowflakeTest
{
    public static void main(String[] args)
    {
        Snowflake snowflake = IdUtil.createSnowflake(0, 5);
        System.out.println(snowflake.nextId());
        long l = IdUtil.createSnowflake(1, 5).nextId();
        System.out.println(l);
        System.out.println(IdUtil.simpleUUID());
    }
}
