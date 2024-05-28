package com.copilot.syncroride.repository;


import com.copilot.syncroride.entity.Ride;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Ride entity.
 * This repository class contains queries to access  details.
 */
@Repository
public interface RideRepository extends JpaRepository<Ride, Long> {
    List<Ride> findByOriginAndDestination(String origin, String destination);
    List<Ride> findByOrigin(String origin);
    List<Ride> findByDestination(String destination);
    List<Ride> findByStopsContaining(String stop);
}
