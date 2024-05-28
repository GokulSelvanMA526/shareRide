package com.copilot.syncroride.entity;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Entity class to store ride details
 * Represents a ride in the commute-sharing application.
 */

@Document(collection = "ride")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ride {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String origin;
    private String destination;
    private Date date;
    private int seatsAvailable;
    private String vehicleType; // Two-wheeler or Four-wheeler

    @ElementCollection
    private List<String> stops;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
