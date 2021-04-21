package com.cloud.provider.controller;

import com.cloud.provider.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class MessageProvider {

    @Resource
    private IMessageProvider provider;

    @GetMapping("/publish")
    public void publishMessage(){
        provider.publishMessage();
    }
}
