package com.cloud.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "cloudalibaba-provider-payment",fallback = OrderServiceFallback.class)
public interface OrderService {

    @GetMapping("/getId/{id}")
    String getId(@PathVariable(value = "id") Integer id);

}
