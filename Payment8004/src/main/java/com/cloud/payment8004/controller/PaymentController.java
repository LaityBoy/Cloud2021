package com.cloud.payment8004.controller;




import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
public class PaymentController {
    @Value(value = "${server.port}")
    private String serverPort;

    @GetMapping("/payment/getPort")
    public String getPort(){

        return serverPort+"UUID:"+ UUID.randomUUID();
    }
}
