package kh.edu.icstad.fsbankingapi.controller;

import jakarta.validation.Valid;
import kh.edu.icstad.fsbankingapi.dto.customer.CreateCustomerRequest;
import kh.edu.icstad.fsbankingapi.dto.customer.CustomerResponse;
import kh.edu.icstad.fsbankingapi.service.impl.CustomerServiceImplement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    private final CustomerServiceImplement customerService;

    @GetMapping()
    public List<CustomerResponse> findAllCustomers() {
        return customerService.findAllCustomers();
    }


    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerResponse createCustomer(@Valid @RequestBody CreateCustomerRequest customerRequest) {
        return customerService.createCustomer(customerRequest);
    }
}
