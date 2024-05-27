package com.copilot.syncroride.model;

import lombok.Data;

/**
 * Data Transfer Object for user signup requests.
 */
@Data
public class SignUpRequest {
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String gender;
}
