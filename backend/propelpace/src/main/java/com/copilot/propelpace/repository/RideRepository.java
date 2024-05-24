package com.copilot.propelpace.repository;


import com.copilot.propelpace.entity.Ride;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RideRepository extends JpaRepository<Ride, Long> {
}
