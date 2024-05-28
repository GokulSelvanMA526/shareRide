package com.copilot.syncroride.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EmailValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidCompanyEmail {
    String message() default "Email should end with @comcast.com";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}