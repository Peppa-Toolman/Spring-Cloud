package com.toolmanclub.springcloud.service.impl;

import com.toolmanclub.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author Yujie Wang
 * @date 2020/7/13 20:27
 */
@EnableBinding(Source.class)  // 绑定信道channel和exchange绑定在一起
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output;  // 消息发送管道

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        // 构建消息
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("****serial" + serial);
        return null;
    }
}
