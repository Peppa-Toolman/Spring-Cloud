package springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

/**
 * @author Yujie Wang
 * @date 2020/7/13 21:14
 */
@EnableBinding(Sink.class)
public class ReceiveMessageListenerController {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void intput(Message<String> message) {

        System.out.println("消费者一号------->接收到的消息:" + message.getPayload() + "\tport:" + serverPort);
    }
}