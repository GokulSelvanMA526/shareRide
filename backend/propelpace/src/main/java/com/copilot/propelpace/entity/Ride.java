package com.copilot.propelpace.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity class to store ride details
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@Table(name = "ride")
public class Ride {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String origin;
    private String destination;
    private String date;
    private int seatsAvailable;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
