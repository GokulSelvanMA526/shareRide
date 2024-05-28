package com.copilot.syncroride.entity;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity class to store ride details
 * Represents a ride in the commute-sharing application.
 * This class is used to map the Ride objects in the application in a MySql Table named ride,
 * as indicated by the @Table(name = "ride") annotation.
 */

// The Ride class is annotated with @Data, @AllArgsConstructor, @NoArgsConstructor, and
// @Builder from the Lombok library.
// These annotations automatically generate getters and setters,
// a constructor with all arguments, a no-argument constructor, and
// a builder method for the Ride class, respectively.
@Table(name = "ride")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Ride {

    // The id field is annotated with @Id, @Column(nullable = false), and
    // @GeneratedValue(strategy = GenerationType.IDENTITY).
    // This means that it is the primary key of the Ride document, it cannot be null, and
    // its value is auto-generated by the database.
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // The origin, destination, date, seatsAvailable, and
    // vehicleType fields represent the origin and
    // destination of the ride, the date of the ride,
    // the number of available seats, and
    // the type of vehicle used for the ride, respectively.
    private String origin;
    private String destination;
    private Date date;
    private int seatsAvailable;
    private String vehicleType; // Two-wheeler or Four-wheeler

    // The stops field is a list of strings that represent the stops along the ride.
    // It is annotated with @ElementCollection,
    // which means that it is a collection of basic type elements.
    @ElementCollection
    private List<String> stops;

    // The user field represents the user who offers the ride.
    // It is annotated with @ManyToOne and @JoinColumn(name = "user_id"),
    // which means that it is a many-to-one relationship with the User entity, and
    // the foreign key in the Ride document is user_id.
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}