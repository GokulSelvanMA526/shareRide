package com.copilot.syncroride.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * Data Transfer Object for user login requests.
 */
@Data
public class LoginRequest {
    @NotBlank(message = "employeeId cannot be blank")
    @NotNull(message = "employeeId cannot be null")
    private String employeeId;

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;
}
