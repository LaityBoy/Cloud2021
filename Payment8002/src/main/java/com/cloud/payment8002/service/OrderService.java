package com.cloud.payment8002.service;


import com.cloud.common.entitys.Order;

public interface OrderService {
    //插入
    int create(Order order);

    //查询
    Order find(Long id);
}
