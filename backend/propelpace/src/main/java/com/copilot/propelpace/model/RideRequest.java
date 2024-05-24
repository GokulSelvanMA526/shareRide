package com.copilot.propelpace.model;

import lombok.Data;

@Data
public class RideRequest {
    private String origin;
    private String destination;
    private String date;
    private int seatsAvailable;
    private Long userId;
}
