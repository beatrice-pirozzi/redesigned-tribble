package com.allane.leasing.contract;

import org.springframework.data.repository.CrudRepository;

public interface ContractRepository extends CrudRepository<Contract, Integer> {

    boolean existsByVehicleId(Integer vehicleId);
}
