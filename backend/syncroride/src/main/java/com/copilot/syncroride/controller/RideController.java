package com.copilot.syncroride.controller;

import com.copilot.syncroride.model.RideRequest;
import com.copilot.syncroride.model.RideResponse;
import com.copilot.syncroride.serviceimpl.RideServiceImpl;
import jakarta.validation.Valid;
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


// RideController is a REST controller that handles HTTP requests related to rides.
// It uses the RideServiceImpl to perform operations and return responses.


// RideController class is annotated with @RestController, @RequestMapping, @RequiredArgsConstructor, and @Validated.
// @RestController annotation is used to define a controller in a Spring MVC application.
// @RequestMapping("/syncroride/api/rides") annotation is used to map web requests onto specific handler classes and/or handler methods.
// @RequiredArgsConstructor is a Lombok annotation to generate a constructor with required fields, and
// @Validated is used to enable validation of the fields

@RestController
@RequestMapping("/syncroride/api/rides")
@RequiredArgsConstructor
@Validated
public class RideController {
    private static Logger log = LoggerFactory.getLogger(RideController.class);

    // The class has an instance of RideServiceImpl which is autowired using @Autowired annotation.
    // This service is used to perform operations related to rides.
    @Autowired
    private RideServiceImpl rideService;

    // The getAllRides() method is mapped to a GET request and returns a list of all rides.
    // It uses the getAllRides() method of RideServiceImpl to fetch the rides and
    // returns them wrapped in a ResponseEntity.
    @GetMapping
    public ResponseEntity<List<RideResponse>> getAllRides() {
        List<RideResponse> rides = rideService.getAllRides();
        return ResponseEntity.ok(rides);
    }


    // The getRideById(@PathVariable Long id) method is mapped to a GET request with a path variable.
    // It fetches a ride by its id.
    // If the ride is found, it returns the ride wrapped in a ResponseEntity, otherwise,
    // it returns a not found response.
    @GetMapping("/{id}")
    public ResponseEntity<RideResponse> getRideById(@PathVariable Long id) {
        Optional<RideResponse> ride = rideService.getRideById(id);
        return ride.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    // The createRide(@RequestBody RideRequest rideRequest) method is mapped to a POST request.
    // It creates a new ride with the details provided in the request body and returns the created ride.
    @PostMapping("/create")
    public ResponseEntity<RideResponse> createRide(@Valid @RequestBody RideRequest rideRequest) {
        RideResponse savedRide = rideService.addRide(rideRequest);
        return ResponseEntity.ok(savedRide);
    }


    // The joinRide(@PathVariable Long rideId, @RequestParam Long userId) method is mapped to a POST request.
    // It allows a user to join a ride.
    // If the operation is successful, it returns the joined ride, otherwise,
    // it returns a bad request response.
    @PostMapping("/{rideId}/join")
    public ResponseEntity<RideResponse> joinRide(@PathVariable Long rideId, @RequestParam Long userId) {
        Optional<RideResponse> joinedRide = rideService.joinRide(rideId, userId);
        return joinedRide.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
    }


    //The updateRide(@PathVariable Long id, @RequestBody RideRequest rideDetails) method is mapped to a PUT request.
    // It updates the details of a ride and
    // returns the updated ride if the operation is successful, otherwise, it returns a not found response.
    @PutMapping("/update/{id}")
    public ResponseEntity<RideResponse> updateRide(@PathVariable Long id, @Valid @RequestBody RideRequest rideDetails) {
        Optional<RideResponse> updatedRide = rideService.updateRide(id, rideDetails);
        return updatedRide.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    // The findRidesByOriginAndDestination(@RequestParam String origin, @RequestParam String destination)
    // method is mapped to a GET request.
    // It finds rides by origin and destination and
    // returns a list of rides that match the search criteria.
    // The response is wrapped in a ResponseEntity.
    // The method uses the findRidesByOriginAndDestination() method of RideServiceImpl to perform the search.
    // The search criteria is provided as request parameters.
    // The method returns a ResponseEntity containing a list of RideResponses that match the search criteria.
    // The method is annotated with @GetMapping("/search") to map it to the "/search" endpoint.
    // The origin and destination parameters are annotated with @RequestParam to indicate that they are request parameters.
    // The method returns a ResponseEntity<List<RideResponse>> which is the response entity containing the list of rides.
    // The ResponseEntity.ok() method is used to create a response entity with the HTTP status 200 (OK) and the list of rides as the body.

    @GetMapping("/search")
    public ResponseEntity<List<RideResponse>> findRidesByOriginAndDestination(@RequestParam String origin, @RequestParam String destination) {
        return ResponseEntity.ok(rideService.findRidesByOriginAndDestination(origin, destination));
    }

    // The findRidesByStops(@RequestParam String stop) method is mapped to a GET request.
    // It finds rides by stop names and
    // returns a list of rides that match the search criteria.
    // The response is wrapped in a ResponseEntity.
    // The method uses the findRidesByStops() method of RideServiceImpl to perform the search.
    // The search criteria is provided as a request parameter.
    //  The method returns a ResponseEntity containing a list of RideResponses that match the search criteria.
    // The method is annotated with @GetMapping("/searchByStop") to map it to the "/searchByStop" endpoint.
    // The stop parameter is annotated with @RequestParam to indicate that it is a request parameter.
    // The method returns a ResponseEntity<List<RideResponse>> which is the response entity containing the list of rides.
    // The ResponseEntity.ok() method is used to create a response entity with the HTTP status 200 (OK) and the list of rides as the body.

    @GetMapping("/searchByStop")
    public ResponseEntity<List<RideResponse>> findRidesByStops(@RequestParam String stop) {
        return ResponseEntity.ok(rideService.findRidesByStops(stop));
    }
}
