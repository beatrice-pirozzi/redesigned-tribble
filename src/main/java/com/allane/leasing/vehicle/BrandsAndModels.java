package com.allane.leasing.vehicle;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;

@Component
public class BrandsAndModels {

    private final static Map<String, Set<String>> MODELS_BY_BRAND = Map.of(
            "Audi", Set.of("A1", "A3", "A4"),
            "BMW", Set.of("X1", "X2", "X3"),
            "VW", Set.of("Polo", "Golf", "Passat")
    );

    public Map<String, Set<String>> getAll() {
        return MODELS_BY_BRAND;
    }

    public boolean areValid(String brand, String model) {
        return MODELS_BY_BRAND.containsKey(brand) && MODELS_BY_BRAND.get(brand).contains(model);
    }
}
