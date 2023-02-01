package com.allane.leasing.customer;

import org.springframework.web.bind.annotation.ResponseStatus;

import static java.lang.String.format;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ResponseStatus(value = BAD_REQUEST)
public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(Integer customerId) {
        super(format("Customer with id '%s' does not exist", customerId));
    }
}
