package com.cloud.order.service;

import com.cloud.order.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient("seata-account-service")
public interface AccountService {

    @PostMapping("/account/decreate")
    CommonResult decreate(@RequestParam("productId") Long productId, @RequestParam("used") BigDecimal used);
}
