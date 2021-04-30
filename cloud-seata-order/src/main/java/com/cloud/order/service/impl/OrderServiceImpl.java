package com.cloud.order.service.impl;

import com.cloud.order.dao.OrderDao;
import com.cloud.order.entity.Order;
import com.cloud.order.service.AccountService;
import com.cloud.order.service.OrderService;
import com.cloud.order.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;

    @Override
    public void create(Order order) {
        log.info("===============>开始创建订单");
        orderDao.create(order);

        log.info("=============>开始修改库存");
        storageService.decreate(order.getProductId(),order.getCount());
        log.info("=============>修改库存结束");

        log.info("=============>开始修改账户金额");
        accountService.decreate(order.getProductId(),order.getMoney());
        log.info("=============>修改账户金额结束");

        log.info("=============>修改订单状态");
        orderDao.update(order.getProductId(),0);
        log.info("=============>订单创建结束");
    }
}
