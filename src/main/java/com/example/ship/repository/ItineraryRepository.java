package com.example.ship.repository;

import com.example.ship.model.Itinerary;
import com.example.ship.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItineraryRepository extends JpaRepository<Itinerary,Long> {
    List<Itinerary> findByUserId(Long userId);
}
