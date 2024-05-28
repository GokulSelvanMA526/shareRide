package com.copilot.syncroride.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;



/**
 * Data Transfer Object for user login requests.
 */
@Data
public class LoginRequest {
    @NotBlank(message = "Email cannot be blank")
    @Size(max = 50, message = "Email must be less than 50 characters")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 8, max = 30, message = "Password must be between 8 and 30 characters")
    private String password;
}
