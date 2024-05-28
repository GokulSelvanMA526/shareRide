package com.copilot.syncroride.serviceimpl;
import com.copilot.syncroride.entity.Ride;
import com.copilot.syncroride.entity.User;
import com.copilot.syncroride.model.RideRequest;
import com.copilot.syncroride.model.RideResponse;
import com.copilot.syncroride.repository.RideRepository;
import com.copilot.syncroride.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class RideServiceImplTest {

    @InjectMocks
    private RideServiceImpl rideService;

    @Mock
    private RideRepository rideRepository;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getAllRides_returnsRideList() {
        Ride ride = new Ride();
        when(rideRepository.findAll()).thenReturn(Arrays.asList(ride));

        List<RideResponse> response = rideService.getAllRides();

        assertEquals(1, response.size());
    }

    @Test
    public void getRideById_returnsRide() {
        Ride ride = new Ride();
        when(rideRepository.findById(1L)).thenReturn(Optional.of(ride));

        Optional<RideResponse> response = rideService.getRideById(1L);

        assertEquals(true, response.isPresent());
    }

    @Test
    public void getRideById_returnsEmpty() {
        when(rideRepository.findById(1L)).thenReturn(Optional.empty());

        Optional<RideResponse> response = rideService.getRideById(1L);

        assertEquals(false, response.isPresent());
    }

    @Test
    public void addRide_returnsCreatedRide() {
        RideRequest rideRequest = new RideRequest();
        Ride ride = new Ride();
        User user = new User();
        when(userRepository.findById(rideRequest.getUserId())).thenReturn(Optional.of(user));
        when(rideRepository.save(ride)).thenReturn(ride);

        RideResponse response = rideService.addRide(rideRequest);

        assertEquals(ride.getId(), response.getId());
    }

    @Test
    public void updateRide_returnsUpdatedRide() {
        RideRequest rideRequest = new RideRequest();
        Ride ride = new Ride();
        User user = new User();
        when(rideRepository.findById(1L)).thenReturn(Optional.of(ride));
        when(userRepository.findById(rideRequest.getUserId())).thenReturn(Optional.of(user));
        when(rideRepository.save(ride)).thenReturn(ride);

        Optional<RideResponse> response = rideService.updateRide(1L, rideRequest);

        assertEquals(true, response.isPresent());
    }

    @Test
    public void updateRide_returnsEmpty() {
        RideRequest rideRequest = new RideRequest();
        when(rideRepository.findById(1L)).thenReturn(Optional.empty());

        Optional<RideResponse> response = rideService.updateRide(1L, rideRequest);

        assertEquals(false, response.isPresent());
    }

    @Test
    public void joinRide_returnsJoinedRide() {
        Ride ride = new Ride();
        User user = new User();
        when(rideRepository.findById(1L)).thenReturn(Optional.of(ride));
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(rideRepository.save(ride)).thenReturn(ride);

        Optional<RideResponse> response = rideService.joinRide(1L, 1L);

        assertEquals(true, response.isPresent());
    }

    @Test
    public void joinRide_returnsEmpty() {
        Ride ride = new Ride();
        when(rideRepository.findById(1L)).thenReturn(Optional.of(ride));
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        Optional<RideResponse> response = rideService.joinRide(1L, 1L);

        assertEquals(false, response.isPresent());
    }

    @Test
    public void findRidesByOriginAndDestination_returnsRideList() {
        Ride ride = new Ride();
        when(rideRepository.findByOriginAndDestination("origin", "destination")).thenReturn(Arrays.asList(ride));

        List<RideResponse> response = rideService.findRidesByOriginAndDestination("origin", "destination");

        assertEquals(1, response.size());
    }

    @Test
    public void findRidesByStops_returnsRideList() {
        Ride ride = new Ride();
        when(rideRepository.findByStopsContaining("stop")).thenReturn(Arrays.asList(ride));

        List<RideResponse> response = rideService.findRidesByStops("stop");

        assertEquals(1, response.size());
    }
}