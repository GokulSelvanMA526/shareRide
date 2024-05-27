package com.copilot.syncroride.model;

import lombok.Data;


/**
 * Data Transfer Object for ride creation requests.
 */
@Data
public class RideRequest {
    private String origin;
    private String destination;
    private String date;
    private int seatsAvailable;
    private Long userId;
}
