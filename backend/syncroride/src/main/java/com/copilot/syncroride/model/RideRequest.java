package com.copilot.syncroride.model;

import java.util.Date;
import java.util.List;
import lombok.Data;


/**
 * Data Transfer Object for ride creation requests.
 */
@Data
public class RideRequest {
    private String origin;
    private String destination;
    private Date date;
    private int seatsAvailable;
    private String vehicleType;
    private Long userId;
    private List<String> stops;
}
