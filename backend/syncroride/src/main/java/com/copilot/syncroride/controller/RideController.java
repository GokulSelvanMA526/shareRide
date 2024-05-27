package com.copilot.syncroride.controller;

import com.copilot.syncroride.model.RideRequest;
import com.copilot.syncroride.model.RideResponse;
import com.copilot.syncroride.serviceimpl.RideServiceImpl;
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
@RequestMapping("/syncroride/api/rides")
@RequiredArgsConstructor
@Validated
public class RideController {
    private static Logger log = LoggerFactory.getLogger(RideController.class);

    @Autowired
    private RideServiceImpl rideService;

    /**
     * fetch all ride details
     */

    @GetMapping
    public ResponseEntity<List<RideResponse>> getAllRides() {
        List<RideResponse> rides = rideService.getAllRides();
        return ResponseEntity.ok(rides);
    }

    /**
     * fetch ride details by id
     * id will provide - unique identifier
     * @param id
     * @return
     */

    @GetMapping("/{id}")
    public ResponseEntity<RideResponse> getRideById(@PathVariable Long id) {
        Optional<RideResponse> ride = rideService.getRideById(id);
        return ride.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * create rideRequest details
     * @param rideRequest
     * @return the ride's response
     */

    @PostMapping("/create")
    public ResponseEntity<RideResponse> createRide(@RequestBody RideRequest rideRequest) {
        RideResponse savedRide = rideService.addRide(rideRequest);
        return ResponseEntity.ok(savedRide);
    }
    /**
     * join ride details data
     * userId - id of an user
     * rideId - id of the ride
     * @return the ride's response
     */

    @PostMapping("/{rideId}/join")
    public ResponseEntity<RideResponse> joinRide(@PathVariable Long rideId, @RequestParam Long userId) {
        Optional<RideResponse> joinedRide = rideService.joinRide(rideId, userId);
        return joinedRide.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    /**
     * update ride details
     * id - id of the ride
     * rideDetails - provide all the details of ride
     * @return the ride's response
     */

    @PutMapping("/update/{id}")
    public ResponseEntity<RideResponse> updateRide(@PathVariable Long id, @RequestBody RideRequest rideDetails) {
        Optional<RideResponse> updatedRide = rideService.updateRide(id, rideDetails);
        return updatedRide.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * find Rides By Origin And Destination
     * origin - pick up location
     * destination - drop location
     * @return all the ride's response
     */
    @GetMapping("/search")
    public ResponseEntity<List<RideResponse>> findRidesByOriginAndDestination(@RequestParam String origin, @RequestParam String destination) {
        return ResponseEntity.ok(rideService.findRidesByOriginAndDestination(origin, destination));
    }

    /**
     * search Rides By Stop Names
     * stop - pick up stop name
     * @return all the ride's response
     */
    @GetMapping("/searchByStop")
    public ResponseEntity<List<RideResponse>> findRidesByStops(@RequestParam String stop) {
        return ResponseEntity.ok(rideService.findRidesByStops(stop));
    }
}
