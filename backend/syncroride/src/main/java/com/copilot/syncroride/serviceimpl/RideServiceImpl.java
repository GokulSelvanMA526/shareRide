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

//The class is annotated with @Service, indicating that it's a service component in the Spring framework.
@Service
public class RideServiceImpl {

    // It has two fields, rideRepository and userRepository, which are instances of RideRepository and
    // UserRepository respectively.
    // These repositories are used to perform database operations related to rides and users.
    // They are automatically injected by Spring, as indicated by the @Autowired annotation.

    @Autowired
    private RideRepository rideRepository;

    @Autowired
    private UserRepository userRepository;

    // The getAllRides method retrieves all rides from the database, converts each ride to a RideResponse object, and
    // returns a list of these objects.
    // The conversion is done by the convertToResponse method.

    public List<RideResponse> getAllRides() {
        return rideRepository.findAll().stream().map(this::convertToResponse).collect(Collectors.toList());
    }


    // The getRideById method retrieves a ride by its ID, converts it to a RideResponse object, and
    // returns an Optional containing the object.
    // If the ride is not found, the Optional is empty.
    public Optional<RideResponse> getRideById(Long id) {
        return rideRepository.findById(id).map(this::convertToResponse);
    }

    // The addRide method takes a RideRequest object,
    // retrieves the user associated with the ride,
    // creates a new Ride object, sets its properties based on the RideRequest object,
    // saves the ride to the database,
    // converts it to a RideResponse object, and
    // returns the object.
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

    // The joinRide method allows a user to join a ride.
    // It retrieves the ride and the user by their IDs,
    // checks if there are available seats,
    // decreases the number of available seats by one,
    // saves the ride to the database, and
    // returns an Optional containing the RideResponse object.
    public Optional<RideResponse> joinRide(Long rideId, Long userId) {
        Ride ride = rideRepository.findById(rideId).orElseThrow(() -> new RuntimeException("Ride not found"));
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        // Check if there are available seats and join the ride...
        if (!ObjectUtils.isEmpty(user) && ride.getSeatsAvailable() > 0) {
            ride.setSeatsAvailable(ride.getSeatsAvailable() - 1);
            rideRepository.save(ride);
            return Optional.of(convertToResponse(ride));
        }
        return Optional.empty();
    }

    // The findRidesByOriginAndDestination and findRidesByStops methods retrieve rides
    // based on their origin and destination, and stops, respectively.
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

    // The convertToResponse method converts a Ride object to a RideResponse object.
    // It creates a new RideResponse object,
    // sets its properties based on the Ride object, and returns the object.

    private RideResponse convertToResponse(Ride ride) {
        RideResponse response = new RideResponse();
        // Set properties of the response...
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
