package com.cloud.consumer.service;

import org.springframework.stereotype.Component;

@Component
public class OrderHystrixService implements OrderService{
    @Override
    public String instance_ok(Integer id) {
        return "OrderHystrixService: instance_ok 宕机";
    }

    @Override
    public String instance_timeOut(Integer id) {
        return "OrderHystrixService: instance_timeOut 宕机";
    }
}
