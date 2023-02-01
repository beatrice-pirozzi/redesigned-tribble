package com.allane.leasing.vehicle;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/vehicles")
@AllArgsConstructor
public class VehicleController {

    private VehicleService vehicleService;
    private BrandsAndModels brandsAndModels;

    @PostMapping
    public VehicleDto createVehicle(@Valid @RequestBody VehicleDto vehicleDto) {
        if (!brandsAndModels.areValid(vehicleDto.getBrand(), vehicleDto.getModel())) {
            throw new InvalidBrandOrModelException(vehicleDto.getBrand(), vehicleDto.getModel());
        }

        return vehicleService.createVehicle(vehicleDto);
    }

    @GetMapping("/brands")
    public Map<String, Set<String>> getBrandsAndModels() {
        return brandsAndModels.getAll();
    }
}
