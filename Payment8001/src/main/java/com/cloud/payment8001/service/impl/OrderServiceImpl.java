package com.cloud.payment8001.service.impl;

import com.cloud.common.entitys.Order;
import com.cloud.payment8001.dao.OrderDao;
import com.cloud.payment8001.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public int create(Order order) {
        return orderDao.create(order);
    }

    @Override
    public Order find(Long id) {
        return orderDao.find(id);
    }
}
