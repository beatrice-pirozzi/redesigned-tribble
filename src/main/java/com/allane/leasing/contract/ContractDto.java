package com.allane.leasing.contract;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ContractDto {

    private Integer id;

    @NotNull
    private Integer monthlyRateInCents;

    @NotNull
    private Integer customerId;

    private Integer vehicleId;
}
