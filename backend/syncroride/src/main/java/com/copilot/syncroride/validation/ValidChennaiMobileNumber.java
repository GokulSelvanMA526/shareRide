package com.copilot.syncroride.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;
import jakarta.validation.constraints.Pattern;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//  @Pattern annotation is used to add regex validation to the mobile number.
//  The regex ^[6789]\\d{9}$ ensures that the mobile number starts with '6', '7', '8', or '9' and
//  is followed by exactly 9 digits,
//  making it a 10-digit valid Indian mobile number.
@Pattern(regexp = "^[6789]\\d{9}$", message = "Mobile number must be a valid Indian number")
@ReportAsSingleViolation
@Documented
@Constraint(validatedBy = {})
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidChennaiMobileNumber {
    String message() default "Invalid Chennai Mobile Number";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}