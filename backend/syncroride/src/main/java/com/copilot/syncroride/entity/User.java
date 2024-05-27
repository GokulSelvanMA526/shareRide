package com.copilot.syncroride.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity class to store user details.
 * Represents a user in the commute-sharing application.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@Table(name = "user")
public class User {

    /**
     * The unique identifier for the user.
     */
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String gender;
}