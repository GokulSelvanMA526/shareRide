package com.copilot.propelpace.model;

import lombok.Data;

/**
 * Data Transfer Object for ride responses.
 */
@Data
public class RideResponse {
    private Long id;
    private String origin;
    private String destination;
    private String date;
    private int seatsAvailable;
    private Long userId;
    private String userName;
    private String userEmail;
}
