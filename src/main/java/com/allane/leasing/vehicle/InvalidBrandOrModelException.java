package com.allane.leasing.vehicle;

import org.springframework.web.bind.annotation.ResponseStatus;

import static java.lang.String.format;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ResponseStatus(value = BAD_REQUEST)
public class InvalidBrandOrModelException extends RuntimeException {

    public InvalidBrandOrModelException(String brand, String model) {
        super(format("Invalid brand '%s' or model '%s'", brand, model));
    }
}
