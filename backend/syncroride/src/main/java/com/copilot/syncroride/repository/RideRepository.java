package com.copilot.syncroride.repository;


import com.copilot.syncroride.entity.Ride;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Repository interface for Ride entity.
 * This repository class contains queries to access  details.
 */
public interface RideRepository extends JpaRepository<Ride, Long> {
}
