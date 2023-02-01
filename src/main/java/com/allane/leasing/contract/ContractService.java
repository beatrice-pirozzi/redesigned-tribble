package com.allane.leasing.contract;

import com.allane.leasing.customer.Customer;
import com.allane.leasing.customer.CustomerDto;
import com.allane.leasing.customer.CustomerNotFoundException;
import com.allane.leasing.customer.CustomerRepository;
import com.allane.leasing.vehicle.Vehicle;
import com.allane.leasing.vehicle.VehicleAlreadyLeasedException;
import com.allane.leasing.vehicle.VehicleDto;
import com.allane.leasing.vehicle.VehicleNotFoundException;
import com.allane.leasing.vehicle.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ContractService {

    private ContractRepository contractRepository;
    private CustomerRepository customerRepository;
    private VehicleRepository vehicleRepository;

    // TODO mapstruct
    public ContractDetailsDto getContract(Integer id) {
        var contract = contractRepository.findById(id)
                .orElseThrow(() -> new ContractNotFoundException(id));

        var contractDetails = new ContractDetailsDto();
        contractDetails.setId(contract.getId());
        contractDetails.setMonthlyRateInCents(contract.getMonthlyRateInCents());

        var customer = contract.getCustomer();
        var customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setFirstName(customer.getFirstName());
        customerDto.setLastName(customer.getLastName());
        customerDto.setBirthDate(customer.getBirthDate());
        contractDetails.setCustomer(customerDto);

        var vehicle = contract.getVehicle();
        var vehicleDto = new VehicleDto();
        vehicleDto.setId(vehicle.getId());
        vehicleDto.setBrand(vehicle.getBrand());
        vehicleDto.setModel(vehicle.getModel());
        vehicleDto.setModelYear(vehicle.getModelYear());
        vehicleDto.setVin(vehicle.getVin());
        vehicleDto.setPriceInCents(vehicle.getPriceInCents());
        contractDetails.setVehicle(vehicleDto);

        return contractDetails;
    }

    public ContractDto createContract(ContractDto contractDto) {
        var contract = new Contract();

        contract.setMonthlyRateInCents(contractDto.getMonthlyRateInCents());

        var customer = ensureCustomerExist(contractDto.getCustomerId());
        contract.setCustomer(customer);

        if (contractDto.getVehicleId() != null) {
            var vehicle = ensureVehicleExistsAndNotLeased(contractDto.getVehicleId());
            contract.setVehicle(vehicle);
        }

        var savedContract = contractRepository.save(contract);

        contractDto.setId(savedContract.getId());
        return contractDto;
    }

    public ContractDto updateContract(ContractDto contractDto) {
        var contract = contractRepository.findById(contractDto.getId())
                .orElseThrow(() -> new ContractNotFoundException(contractDto.getId()));

        contract.setMonthlyRateInCents(contractDto.getMonthlyRateInCents());

        if (!contractDto.getCustomerId().equals(contract.getCustomer().getId())) {
            var customer = ensureCustomerExist(contractDto.getCustomerId());
            contract.setCustomer(customer);
        }

        if (contractDto.getVehicleId() == null) {
            contract.setVehicle(null);
        } else if (contract.getVehicle() == null || !contract.getVehicle().getId().equals(contractDto.getVehicleId())) {
            var vehicle = ensureVehicleExistsAndNotLeased(contractDto.getVehicleId());
            contract.setVehicle(vehicle);
        }

        contractRepository.save(contract);

        return contractDto;
    }

    private Customer ensureCustomerExist(Integer customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(customerId));
    }

    private Vehicle ensureVehicleExistsAndNotLeased(Integer vehicleId) {
        var vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new VehicleNotFoundException(vehicleId));
        if (contractRepository.existsByVehicleId(vehicleId)) {
            throw new VehicleAlreadyLeasedException(vehicleId);
        }
        return vehicle;
    }
}
