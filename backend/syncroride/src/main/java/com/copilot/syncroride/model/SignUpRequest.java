package com.copilot.syncroride.model;

import com.copilot.syncroride.validation.ValidChennaiMobileNumber;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * Data Transfer Object for user signup requests.
 */
@Data
public class SignUpRequest {
    @NotBlank(message = "Name is mandatory")
    @Size(min = 1, max = 50, message = "Name must be between 1 and 50 characters")
    private String name;

    @NotBlank(message = "employeeId cannot be blank")
    @NotNull(message = "employeeId cannot be null")
    private String employeeId;

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;

    // @ValidChennaiMobileNumber  annotation will validate that the phone number starts with the area code for Chennai and
    // has the correct length.
    // Mobile numbers in India typically start with a '9', '8', '7', or '6' and are 10 digits long.
    // Now, when a user tries to sign up with a phone number that doesn't meet the criteria,
    // they will receive an error message.
    @NotBlank(message = "Mobile number cannot be blank")
    @ValidChennaiMobileNumber
    private String mobileNumber;

    @NotBlank(message = "Gender cannot be blank")
    @Pattern(regexp = "^(Male|Female|Other)$", message = "Gender must be either Male, Female, or Other")
    private String gender;

}
