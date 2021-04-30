package com.cloud.order.dao;

import com.cloud.order.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderDao {

    //===========创建订单
    void create(Order order);

    //============修改订单状态
    void update(@Param("productId") Long productId,@Param("sataus") Integer status);
}
