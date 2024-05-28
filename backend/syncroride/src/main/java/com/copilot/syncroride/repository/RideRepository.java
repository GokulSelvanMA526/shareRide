package com.copilot.syncroride.repository;


import com.copilot.syncroride.entity.Ride;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;


/**
 * Repository interface for Ride entity.
 * This repository class contains queries to access  details.
 */
public interface RideRepository extends MongoRepository<Ride, Long> {
    List<Ride> findByOriginAndDestination(String origin, String destination);

    List<Ride> findByStopsContaining(String stop);
}
