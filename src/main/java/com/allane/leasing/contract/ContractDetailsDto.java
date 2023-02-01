package com.allane.leasing.contract;

import com.allane.leasing.customer.CustomerDto;
import com.allane.leasing.vehicle.VehicleDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContractDetailsDto {

    private Integer id;
    private Integer monthlyRateInCents;
    private CustomerDto customer;
    private VehicleDto vehicle;
}
