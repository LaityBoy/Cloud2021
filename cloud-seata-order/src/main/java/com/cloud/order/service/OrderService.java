package com.cloud.order.service;

import com.cloud.order.entity.Order;

public interface OrderService {

    //用户下单流程
    void create(Order order);
}
