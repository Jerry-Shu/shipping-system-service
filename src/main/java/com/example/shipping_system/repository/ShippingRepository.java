package com.example.shipping_system.repository;

import com.example.shipping_system.entity.Shipment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ShippingRepository {

    private final Map<Long, Shipment> shipments =
            new ConcurrentHashMap<>();

    private final AtomicLong idGenerator =
            new AtomicLong(1);

    public Shipment save(Shipment shipment) {

        if (shipment.getId() == null) {
            shipment.setId(
                    idGenerator.getAndIncrement()
            );
        }

        shipments.put(
                shipment.getId(),
                shipment
        );

        return shipment;
    }

    public Optional<Shipment> findById(Long id) {

        return Optional.ofNullable(
                shipments.get(id)
        );
    }

    public List<Shipment> findAll() {

        return new ArrayList<>(
                shipments.values()
        );
    }
}