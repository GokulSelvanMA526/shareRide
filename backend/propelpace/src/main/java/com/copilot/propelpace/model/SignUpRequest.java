package com.copilot.propelpace.model;

import lombok.Data;

@Data
public class SignUpRequest {
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String gender;
}
