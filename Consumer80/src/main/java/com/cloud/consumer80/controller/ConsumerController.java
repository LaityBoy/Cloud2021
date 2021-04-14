package com.cloud.consumer80.controller;

import com.cloud.common.entitys.CommonResult;
import com.cloud.common.entitys.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
@RequestMapping("/consumer")
public class ConsumerController {

    private final static String PAYMENT_URL="http://PAYMENT/";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/create")
    public CommonResult<Order> create( Order order){
       return restTemplate.postForObject(PAYMENT_URL+"order/create",order,CommonResult.class);
    }

    @GetMapping("/find/{id}")
    public CommonResult<Order> find(@PathVariable Long id){
        return restTemplate.getForObject(PAYMENT_URL+"order/find/"+id,CommonResult.class);
    }
}
