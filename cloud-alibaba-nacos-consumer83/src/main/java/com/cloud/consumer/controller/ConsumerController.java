package com.cloud.consumer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class ConsumerController {

    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serviceUri;

    @GetMapping("/consumer/payment/getId/{id}")
    public String getId(@PathVariable(value = "id") Integer id){
        return restTemplate.getForObject(serviceUri+"/payment/getId/"+id,String.class);
    }
}
