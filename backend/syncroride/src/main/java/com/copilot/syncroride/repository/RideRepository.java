package com.copilot.syncroride.repository;


import com.copilot.syncroride.entity.Ride;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for Ride entity.
 * This repository class contains queries to access  details.
 */
public interface RideRepository extends JpaRepository<Ride, Long> {
    List<Ride> findByOriginAndDestination(String origin, String destination);
    List<Ride> findByOrigin(String origin);
    List<Ride> findByDestination(String destination);
    List<Ride> findByStopsContaining(String stop);
}
