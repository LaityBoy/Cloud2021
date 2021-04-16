package com.cloud.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "PAYMENT-HYSTRIX",fallback = OrderHystrixService.class)
public interface OrderService {

    @GetMapping("/payment/ok/{id}")
    String instance_ok(@PathVariable(value = "id") Integer id);

    @GetMapping("/payment/timeOut/{id}")
    String instance_timeOut(@PathVariable(value = "id") Integer id);
}
