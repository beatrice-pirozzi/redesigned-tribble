package com.allane.leasing.vehicle;

import org.springframework.web.bind.annotation.ResponseStatus;

import static java.lang.String.format;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ResponseStatus(value = NOT_FOUND)
public class VehicleNotFoundException extends RuntimeException {

    public VehicleNotFoundException(Integer vehicleId) {
        super(format("Vehicle with id '%s' does not exist", vehicleId));
    }
}
