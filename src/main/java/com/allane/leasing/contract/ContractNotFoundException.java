package com.allane.leasing.contract;

import org.springframework.web.bind.annotation.ResponseStatus;

import static java.lang.String.format;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ResponseStatus(value = BAD_REQUEST)
public class ContractNotFoundException extends RuntimeException {

    public ContractNotFoundException(Integer contractId) {
        super(format("Contract with id '%s' does not exist", contractId));
    }
}
