package com.example.shipping_system.service;

import com.example.shipping_system.entity.Shipment;
import com.example.shipping_system.repository.ShippingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShippingService {

    private final ShippingRepository shippingRepository;

    public ShippingService(
            ShippingRepository shippingRepository) {

        this.shippingRepository = shippingRepository;
    }

    public Shipment createShipment(Shipment shipment) {

        shipment.setId(null);

        shipment.setStatus("CREATED");

        Shipment savedShipment =
                shippingRepository.save(shipment);

        System.out.println(
                "Shipment created for order: "
                        + savedShipment.getOrderId()
        );

        return savedShipment;
    }

    public Shipment getShipment(Long id) {

        return shippingRepository
                .findById(id)
                .orElse(null);
    }

    public List<Shipment> getAllShipments() {

        return shippingRepository.findAll();
    }
}