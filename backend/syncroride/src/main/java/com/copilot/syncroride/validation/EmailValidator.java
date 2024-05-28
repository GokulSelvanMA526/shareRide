package com.copilot.syncroride.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<ValidCompanyEmail, String> {
    private static final String COMPANY_DOMAIN = "@comcast.com";

    @Override
    public void initialize(ValidCompanyEmail constraintAnnotation) {
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return email != null && email.toLowerCase().endsWith(COMPANY_DOMAIN);
    }
}