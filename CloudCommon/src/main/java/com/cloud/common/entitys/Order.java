package com.cloud.common.entitys;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {
    private Long id;
    private String orderNo;
}
