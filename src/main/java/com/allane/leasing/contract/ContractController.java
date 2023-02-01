package com.allane.leasing.contract;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/contracts")
@AllArgsConstructor
public class ContractController {

    private ContractService contractService;

    @GetMapping("/{id}")
    public ContractDetailsDto getContract(@PathVariable("id") Integer id) {
        return contractService.getContract(id);
    }

    @PostMapping
    public ContractDto createContract(@Valid @RequestBody ContractDto contractDto) {
        return contractService.createContract(contractDto);
    }

    @PutMapping("/{id}")
    public ContractDto updateContract(@PathVariable("id") Integer id, @Valid @RequestBody ContractDto contractDto) {
        contractDto.setId(id);
        return contractService.updateContract(contractDto);
    }
}
