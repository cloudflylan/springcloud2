package com.lanye.springcloud.service.impl;

import com.lanye.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

import java.util.UUID;

@EnableBinding(Source.class)//定义消息的推送管道
public class MessageProviderImpl implements IMessageProvider
{
    @Autowired
    private MessageChannel output;

    @Override
    public String send()
    {
        String s = UUID.randomUUID().toString();
        Message<String> build = MessageBuilder.withPayload(s).build();
        output.send(build);
        System.out.println("产生消息："+ s);
        return s;
    }
}
