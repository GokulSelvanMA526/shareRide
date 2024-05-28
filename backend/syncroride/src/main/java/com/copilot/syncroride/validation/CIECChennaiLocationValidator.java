package com.copilot.syncroride.validation;

import com.copilot.syncroride.model.RideRequest;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CIECChennaiLocationValidator implements ConstraintValidator<ValidCIECChennaiLocation, RideRequest> {

    @Override
    public boolean isValid(RideRequest rideRequest, ConstraintValidatorContext context) {
        return "CIEC Chennai".equals(rideRequest.getOrigin()) || "CIEC Chennai".equals(rideRequest.getDestination());
    }
}