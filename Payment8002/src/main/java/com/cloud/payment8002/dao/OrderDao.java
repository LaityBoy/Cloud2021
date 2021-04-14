package com.cloud.payment8002.dao;


import com.cloud.common.entitys.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderDao {

    //插入
    int create(Order order);

    //查询
    Order find(Long id);
}
