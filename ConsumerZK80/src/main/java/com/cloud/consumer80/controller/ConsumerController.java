package com.cloud.consumer80.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String INVOKE_URL="http://Payment/";

    @GetMapping("/consumer/getPort")
    public String getPort(){
        return restTemplate.getForObject(INVOKE_URL+"payment/getPort",String.class);
    }
}
