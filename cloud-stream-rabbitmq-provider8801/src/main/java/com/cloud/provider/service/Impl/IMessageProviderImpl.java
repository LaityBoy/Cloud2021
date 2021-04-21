package com.cloud.provider.service.Impl;

import cn.hutool.core.util.IdUtil;
import com.cloud.provider.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

@EnableBinding(Source.class)//与队列进行绑定,定义生产者
@Slf4j
public class IMessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output;//引入管道进行信息的发送

    @Override
    public String publishMessage() {

        String uuid = IdUtil.randomUUID();
        output.send(MessageBuilder.withPayload(uuid).build());//消息发送
        log.info("生产者发送消息:"+uuid);
        return null;
    }
}
