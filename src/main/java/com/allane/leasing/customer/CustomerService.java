package com.allane.leasing.customer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerDto createCustomer(CustomerDto customerDto) {
        var customer = new Customer();
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setBirthDate(customerDto.getBirthDate());

        var savedCustomer = customerRepository.save(customer);

        customerDto.setId(savedCustomer.getId());
        return customerDto;
    }
}
