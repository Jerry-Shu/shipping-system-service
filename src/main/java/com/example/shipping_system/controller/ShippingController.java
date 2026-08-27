package com.example.shipping_system.controller;

import com.example.shipping_system.entity.Shipment;
import com.example.shipping_system.service.ShippingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shipments")
public class ShippingController {

    private final ShippingService shippingService;

    public ShippingController(
            ShippingService shippingService) {

        this.shippingService = shippingService;
    }

    @PostMapping
    public Shipment createShipment(
            @RequestBody Shipment shipment) {

        return shippingService.createShipment(shipment);
    }

    @GetMapping
    public List<Shipment> getAllShipments() {

        return shippingService.getAllShipments();
    }

    @GetMapping("/{id}")
    public Shipment getShipment(
            @PathVariable Long id) {

        return shippingService.getShipment(id);
    }
}