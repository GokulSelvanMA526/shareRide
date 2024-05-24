package com.copilot.propelpace.controller;

import com.copilot.propelpace.model.RideRequest;
import com.copilot.propelpace.model.RideResponse;
import com.copilot.propelpace.serviceimpl.RideServiceImpl;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/propelpace/api/rides")
@RequiredArgsConstructor
@Validated
public class RideController {
    private static Logger log = LoggerFactory.getLogger(RideController.class);

    @Autowired
    private RideServiceImpl rideService;

    @GetMapping
    public ResponseEntity<List<RideResponse>> getAllRides() {
        List<RideResponse> rides = rideService.getAllRides();
        return ResponseEntity.ok(rides);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RideResponse> getRideById(@PathVariable Long id) {
        Optional<RideResponse> ride = rideService.getRideById(id);
        return ride.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ResponseEntity<RideResponse> createRide(@RequestBody RideRequest ride) {
        RideResponse savedRide = rideService.addRide(ride);
        return ResponseEntity.ok(savedRide);
    }
    @PostMapping("/{rideId}/join")
    public ResponseEntity<RideResponse> joinRide(@PathVariable Long rideId, @RequestParam Long userId) {
        Optional<RideResponse> joinedRide = rideService.joinRide(rideId, userId);
        return joinedRide.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<RideResponse> updateRide(@PathVariable Long id, @RequestBody RideRequest rideDetails) {
        Optional<RideResponse> updatedRide = rideService.updateRide(id, rideDetails);
        return updatedRide.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
