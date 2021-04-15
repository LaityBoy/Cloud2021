package com.cloud.consumer.controller;

import com.cloud.common.entitys.CommonResult;
import com.cloud.common.entitys.Order;
import com.cloud.consumer.service.PaymentFeginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
//@RequestMapping("/consumer")
public class ConsumerFeginController {

    @Autowired
    private PaymentFeginService paymentFeginService;

    @GetMapping(value = "/consumer/find/{id}")
    public CommonResult<Order> find(@PathVariable(value = "id") Long id){
        return paymentFeginService.find(id);
    }
}
