package com.allane.leasing.vehicle;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class VehicleDto {

    private Integer id;

    @NotBlank
    private String brand;

    @NotBlank
    private String model;

    @NotNull
    private Short modelYear;

    @Size(max = 17)
    private String vin;

    @NotNull
    private Integer priceInCents;
}
