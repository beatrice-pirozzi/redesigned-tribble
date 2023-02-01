package com.allane.leasing.vehicle;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VehicleService {

    private VehicleRepository vehicleRepository;

    public VehicleDto createVehicle(VehicleDto vehicleDto) {
        var vehicle = new Vehicle();
        vehicle.setBrand(vehicleDto.getBrand());
        vehicle.setModel(vehicleDto.getModel());
        vehicle.setModelYear(vehicleDto.getModelYear());
        vehicle.setVin(vehicleDto.getVin());
        vehicle.setPriceInCents(vehicleDto.getPriceInCents());

        var savedVehicle = vehicleRepository.save(vehicle);

        vehicleDto.setId(savedVehicle.getId());
        return vehicleDto;
    }
}
