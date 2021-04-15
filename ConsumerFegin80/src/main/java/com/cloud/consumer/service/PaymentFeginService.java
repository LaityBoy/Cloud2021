package com.cloud.consumer.service;

import com.cloud.common.entitys.CommonResult;
import com.cloud.common.entitys.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "PAYMENT")
public interface PaymentFeginService {

    @GetMapping(value = "/order/find/{id}")
    CommonResult<Order> find(@PathVariable(value = "id") Long id);
}
