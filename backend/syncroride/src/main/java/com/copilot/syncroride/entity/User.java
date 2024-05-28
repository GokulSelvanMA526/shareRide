package com.copilot.syncroride.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Entity class to store user details.
 * Represents a user in the commute-sharing application.
 * This class is used to map the User objects in the application to documents in a MongoDB collection named user,
 * as indicated by the @Document(collection = "user") annotation.
 */

// The User class is annotated with @Data, @AllArgsConstructor, @NoArgsConstructor, and
// @Builder from the Lombok library. These annotations automatically generate getters and setters,
// a constructor with all arguments, a no-argument constructor, and
// a builder method for the User class, respectively.
@Document(collection = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    /**
     * The unique identifier for the user.
     */
    @Id
    // @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // The name, email, password, phoneNumber, and
    // gender fields represent the name, email, password,
    // phone number, and gender of the user, respectively.
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String gender;
}