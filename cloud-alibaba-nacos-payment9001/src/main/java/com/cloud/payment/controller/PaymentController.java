package com.cloud.payment.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/payment/getId/{id}")
    public String getId(@PathVariable(value = "id") Integer id){
        return "nacos注册成功, 端口为:"+port+"\t id为:"+id;
    }
}
