package com.lanye.springcloud.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class CommonResult<T> implements Serializable
{

    private Integer code;
    private String message;
    private T data;

    public static <T> CommonResult<T> commonResult(int code, String message, T o)
    {
        CommonResult commonResult = new CommonResult();
        commonResult.setCode(code);
        commonResult.setMessage(message);
        commonResult.setData(o);
        return commonResult;
    }


    public static <T> CommonResult<T> success()
    {
        return commonResult(200, "成功", null);
    }

    public static <T> CommonResult<T> success(T data)
    {
        return commonResult(200, "成功", data);
    }

    public static <T> CommonResult<T> success(String message,T data)
    {
        return commonResult(200, message, data);
    }

    public static <T> CommonResult<T> fail(String message)
    {
        return commonResult(500, message, null);
    }

    public static <T> CommonResult<T> fail()
    {
        return commonResult(500, "失败", null);
    }

    public static <T> CommonResult<T> fail(String message,T data)
    {
        return commonResult(500, message, data);
    }
}
