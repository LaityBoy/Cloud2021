package com.cloud.order.service;

import com.cloud.order.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("seata-storage-service")
public interface StorageService {

    @PostMapping("/storage/decreate")
    CommonResult decreate(@RequestParam("productId") Long productId,@RequestParam("used") Integer used);
}
