package com.cloud.consumer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Component
@EnableBinding(Sink.class)//绑定通道，定义消费者
@Slf4j
public class ConsumerController {

    @Value("${server.port}")
    private String port;

    @StreamListener(Sink.INPUT)//监听队列中的消息
    public void getMessage(Message<String> message){
        log.info("消费者拿到消息:"+message.getPayload()+"\t 端口为:"+port);
    }
}
