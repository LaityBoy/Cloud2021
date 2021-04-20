package com.cloud.payment.controller;

import com.cloud.payment.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("/payment/ok/{id}")
    public String instance_ok(@PathVariable(value = "id") Integer id){

        return paymentService.instance_ok(id);
    }

    @GetMapping("/payment/timeOut/{id}")
    public String instance_timeOut(@PathVariable(value = "id") Integer id){

        return paymentService.instance_timeOut(id);
    }

    @GetMapping("/payment/instance_id/{id}")
    public String instance_id(@PathVariable(value = "id") Integer id){
        return paymentService.instance_id(id);
    }
}
