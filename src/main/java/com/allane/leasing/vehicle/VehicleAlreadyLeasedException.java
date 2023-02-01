package com.allane.leasing.vehicle;

import org.springframework.web.bind.annotation.ResponseStatus;

import static java.lang.String.format;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ResponseStatus(value = BAD_REQUEST)
public class VehicleAlreadyLeasedException extends RuntimeException {

    public VehicleAlreadyLeasedException(Integer vehicleId) {
        super(format("Vehicle with id '%s' is already in leasing", vehicleId));
    }
}
