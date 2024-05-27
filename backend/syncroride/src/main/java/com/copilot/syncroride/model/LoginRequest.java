package com.copilot.syncroride.model;

import lombok.Data;


/**
 * Data Transfer Object for user login requests.
 */
@Data
public class LoginRequest {
    private String email;
    private String password;
}
