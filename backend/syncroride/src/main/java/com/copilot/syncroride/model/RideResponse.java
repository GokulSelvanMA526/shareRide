package com.copilot.syncroride.model;

import java.util.Date;
import java.util.List;
import lombok.Data;

/**
 * Data Transfer Object for ride responses.
 */
@Data
public class RideResponse {
    private Long id;
    private String origin;
    private String destination;
    private Date date;
    private int seatsAvailable;
    private String vehicleType;
    private List<String> stops;
    private Long userId;
    private String userName;
    private String userEmail;
}
