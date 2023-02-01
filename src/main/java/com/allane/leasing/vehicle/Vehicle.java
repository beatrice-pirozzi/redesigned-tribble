package com.allane.leasing.vehicle;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "vehicles")
@Getter
@Setter
public class Vehicle {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    private String brand;

    private String model;

    private Short modelYear;

    private String vin;

    private Integer priceInCents;
}
