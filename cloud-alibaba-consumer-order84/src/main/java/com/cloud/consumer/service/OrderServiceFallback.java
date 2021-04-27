package com.cloud.consumer.service;

import org.springframework.stereotype.Service;

@Service
public class OrderServiceFallback implements OrderService{
    @Override
    public String getId(Integer id) {
        return "全局兜底异常方法";
    }
}
