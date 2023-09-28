package com.example.ship.repository;

import com.example.ship.model.ShippingRequest;
import com.example.ship.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShippingRepository extends JpaRepository<ShippingRequest,Long> {
    List<ShippingRequest> findByUserId(Long userId);
}
