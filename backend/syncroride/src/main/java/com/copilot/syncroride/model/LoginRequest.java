package com.copilot.syncroride.model;

import com.copilot.syncroride.validation.ValidCompanyEmail;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * Data Transfer Object for user login requests.
 */
@Data
public class LoginRequest {
    @NotBlank(message = "Email cannot be blank")
    @ValidCompanyEmail
    private String email;

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;
}
