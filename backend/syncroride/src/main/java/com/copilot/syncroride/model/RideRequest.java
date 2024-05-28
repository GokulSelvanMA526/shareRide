package com.copilot.syncroride.model;

import com.copilot.syncroride.validation.ValidCIECChennaiLocation;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Date;
import java.util.List;
import lombok.Data;


/**
 * Data Transfer Object for ride creation requests.
 */

//  the @ValidCIECChennaiLocation annotation is used to add the custom validation to the RideRequest class.
//  This annotation will validate that either the origin or the destination is "CIEC Chennai".
//  Now, when a user tries to create a ride where neither the origin nor the destination is "CIEC Chennai",
//  they will receive an error message.
@ValidCIECChennaiLocation
@Data
public class RideRequest {

    @NotNull(message = "Origin cannot be null")
    @Size(min = 1, max = 100, message = "Origin must be between 1 and 100 characters")
    private String origin;

    @NotNull(message = "Destination cannot be null")
    @Size(min = 1, max = 100, message = "Destination must be between 1 and 100 characters")
    private String destination;

    private Date date;

    @Min(value = 1, message = "Seats available must be at least 1")
    private int seatsAvailable;

    @NotNull(message = "Vehicle type cannot be null")
    @Size(min = 1, max = 50, message = "Vehicle type must be between 1 and 50 characters")
    private String vehicleType;

    @NotNull(message = "User ID cannot be null")
    private Long userId;

    @Size(min = 1, max = 100, message = "Each stop must be between 1 and 100 characters")
    private List<String> stops;
}

