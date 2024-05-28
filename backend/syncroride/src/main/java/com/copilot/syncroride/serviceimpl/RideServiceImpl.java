package com.copilot.syncroride.serviceimpl;


import com.copilot.syncroride.entity.Ride;
import com.copilot.syncroride.entity.User;
import com.copilot.syncroride.model.RideRequest;
import com.copilot.syncroride.model.RideResponse;
import com.copilot.syncroride.repository.RideRepository;
import com.copilot.syncroride.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;


/**
 * This service class contains methods performing rider service  functionality like creating, updating and joining
 * ride details.
 */
@Service
public class RideServiceImpl {
    @Autowired
    private RideRepository rideRepository;

    @Autowired
    private UserRepository userRepository;

    /**
     * Gets all rides.
     *
     * @return a list of all rides
     */

    public List<RideResponse> getAllRides() {
        return rideRepository.findAll().stream().map(this::convertToResponse).collect(Collectors.toList());
    }


    /**
     * Gets a ride by its ID.
     *
     * @param id the ID of the ride
     * @return an Optional containing the ride's response, or empty if not found
     */
    public Optional<RideResponse> getRideById(Long id) {
        return rideRepository.findById(id).map(this::convertToResponse);
    }

    /**
     * Adds a new ride.
     *
     * @param rideRequest the request containing ride details
     * @return the created ride's response
     */
    public RideResponse addRide(RideRequest rideRequest) {
        User user = userRepository.findById(rideRequest.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
        Ride ride = new Ride();
        ride.setOrigin(rideRequest.getOrigin());
        ride.setDestination(rideRequest.getDestination());
        ride.setDate(rideRequest.getDate());
        ride.setSeatsAvailable(rideRequest.getSeatsAvailable());
        ride.setVehicleType(rideRequest.getVehicleType());
        ride.setStops(rideRequest.getStops());
        ride.setUser(user);
        return convertToResponse(rideRepository.save(ride));
    }

    /**
     * Updates an existing ride.
     *
     * @param rideRequest the request containing ride details
     * @param id          - the ID of the ride
     * @return the updated ride's response
     */

    public Optional<RideResponse> updateRide(Long id, RideRequest rideRequest) {
        return rideRepository.findById(id).map(ride -> {
            User user = userRepository.findById(rideRequest.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
            ride.setOrigin(rideRequest.getOrigin());
            ride.setDestination(rideRequest.getDestination());
            ride.setDate(rideRequest.getDate());
            ride.setSeatsAvailable(rideRequest.getSeatsAvailable());
            ride.setVehicleType(rideRequest.getVehicleType());
            ride.setStops(rideRequest.getStops());
            ride.setUser(user);
            return convertToResponse(rideRepository.save(ride));
        });
    }

    /**
     * Joins an existing ride.
     *
     * @param rideId - the ID of the ride
     * @param userId - the ID of the user
     * @return the ride's response
     */
    public Optional<RideResponse> joinRide(Long rideId, Long userId) {
        Ride ride = rideRepository.findById(rideId).orElseThrow(() -> new RuntimeException("Ride not found"));
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        if (!ObjectUtils.isEmpty(user) && ride.getSeatsAvailable() > 0) {
            ride.setSeatsAvailable(ride.getSeatsAvailable() - 1);
            rideRepository.save(ride);
            return Optional.of(convertToResponse(ride));
        }
        return Optional.empty();
    }

    public List<RideResponse> findRidesByOriginAndDestination(String origin, String destination) {
        return rideRepository.findByOriginAndDestination(origin, destination)
            .stream()
            .map(this::convertToResponse)
            .collect(Collectors.toList());
    }

    public List<RideResponse> findRidesByStops(String stop) {
        return rideRepository.findByStopsContaining(stop)
            .stream()
            .map(this::convertToResponse)
            .collect(Collectors.toList());
    }


    private RideResponse convertToResponse(Ride ride) {
        RideResponse response = new RideResponse();
        response.setId(ride.getId());
        response.setOrigin(ride.getOrigin());
        response.setDestination(ride.getDestination());
        response.setDate(ride.getDate());
        response.setSeatsAvailable(ride.getSeatsAvailable());
        response.setUserId(ride.getUser().getId());
        response.setUserName(ride.getUser().getName());
        response.setUserEmail(ride.getUser().getEmail());
        response.setVehicleType(ride.getVehicleType());
        response.setStops(ride.getStops());
        return response;
    }
}