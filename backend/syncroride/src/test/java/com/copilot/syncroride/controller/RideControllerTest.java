package com.copilot.syncroride.controller;

import com.copilot.syncroride.model.RideRequest;
import com.copilot.syncroride.model.RideResponse;
import com.copilot.syncroride.serviceimpl.RideServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class RideControllerTest {

    @InjectMocks
    private RideController rideController;

    @Mock
    private RideServiceImpl rideService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getAllRides_returnsRideList() {
        RideResponse rideResponse = new RideResponse();
        when(rideService.getAllRides()).thenReturn(Arrays.asList(rideResponse));

        ResponseEntity<List<RideResponse>> response = rideController.getAllRides();

        assertEquals(1, response.getBody().size());
        assertEquals(rideResponse, response.getBody().get(0));
    }

    @Test
    public void getRideById_returnsRide() {
        RideResponse rideResponse = new RideResponse();
        when(rideService.getRideById(1L)).thenReturn(Optional.of(rideResponse));

        ResponseEntity<RideResponse> response = rideController.getRideById(1L);

        assertEquals(rideResponse, response.getBody());
    }

    @Test
    public void getRideById_returnsNotFound() {
        when(rideService.getRideById(1L)).thenReturn(Optional.empty());

        ResponseEntity<RideResponse> response = rideController.getRideById(1L);

        assertEquals(404, response.getStatusCodeValue());
    }

    @Test
    public void createRide_returnsCreatedRide() {
        RideRequest rideRequest = new RideRequest();
        RideResponse rideResponse = new RideResponse();
        when(rideService.addRide(rideRequest)).thenReturn(rideResponse);

        ResponseEntity<RideResponse> response = rideController.createRide(rideRequest);

        assertEquals(rideResponse, response.getBody());
    }

    @Test
    public void joinRide_returnsJoinedRide() {
        RideResponse rideResponse = new RideResponse();
        when(rideService.joinRide(1L, 1L)).thenReturn(Optional.of(rideResponse));

        ResponseEntity<RideResponse> response = rideController.joinRide(1L, 1L);

        assertEquals(rideResponse, response.getBody());
    }

    @Test
    public void joinRide_returnsBadRequest() {
        when(rideService.joinRide(1L, 1L)).thenReturn(Optional.empty());

        ResponseEntity<RideResponse> response = rideController.joinRide(1L, 1L);

        assertEquals(400, response.getStatusCodeValue());
    }

    @Test
    public void updateRide_returnsUpdatedRide() {
        RideRequest rideRequest = new RideRequest();
        RideResponse rideResponse = new RideResponse();
        when(rideService.updateRide(1L, rideRequest)).thenReturn(Optional.of(rideResponse));

        ResponseEntity<RideResponse> response = rideController.updateRide(1L, rideRequest);

        assertEquals(rideResponse, response.getBody());
    }

    @Test
    public void updateRide_returnsNotFound() {
        RideRequest rideRequest = new RideRequest();
        when(rideService.updateRide(1L, rideRequest)).thenReturn(Optional.empty());

        ResponseEntity<RideResponse> response = rideController.updateRide(1L, rideRequest);

        assertEquals(404, response.getStatusCodeValue());
    }

    @Test
    public void findRidesByOriginAndDestination_returnsRideList() {
        RideResponse rideResponse = new RideResponse();
        when(rideService.findRidesByOriginAndDestination("origin", "destination")).thenReturn(Arrays.asList(rideResponse));

        ResponseEntity<List<RideResponse>> response = rideController.findRidesByOriginAndDestination("origin", "destination");

        assertEquals(1, response.getBody().size());
        assertEquals(rideResponse, response.getBody().get(0));
    }

    @Test
    public void findRidesByStops_returnsRideList() {
        RideResponse rideResponse = new RideResponse();
        when(rideService.findRidesByStops("stop")).thenReturn(Arrays.asList(rideResponse));

        ResponseEntity<List<RideResponse>> response = rideController.findRidesByStops("stop");

        assertEquals(1, response.getBody().size());
        assertEquals(rideResponse, response.getBody().get(0));
    }
}