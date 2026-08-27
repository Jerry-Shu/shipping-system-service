package com.example.shipping_system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shipment {

    private Long id;

    private Long orderId;

    private Long productId;

    private Integer quantity;

    private String status;
}