package com.copilot.propelpace.repository;


import com.copilot.propelpace.entity.Ride;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Repository interface for Ride entity.
 * This repository class contains queries to access  details.
 */
public interface RideRepository extends JpaRepository<Ride, Long> {
}
