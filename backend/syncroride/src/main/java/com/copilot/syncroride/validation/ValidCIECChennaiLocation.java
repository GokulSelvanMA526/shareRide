package com.copilot.syncroride.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = CIECChennaiLocationValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidCIECChennaiLocation {
    String message() default "Either origin or destination should be CIEC Chennai";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}