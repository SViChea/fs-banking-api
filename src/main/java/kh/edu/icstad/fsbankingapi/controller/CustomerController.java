package kh.edu.icstad.fsbankingapi.controller;

import jakarta.validation.Valid;
import kh.edu.icstad.fsbankingapi.base.BaseResponse;
import kh.edu.icstad.fsbankingapi.dto.customer.CreateCustomerRequest;
import kh.edu.icstad.fsbankingapi.dto.customer.CustomerResponse;
import kh.edu.icstad.fsbankingapi.dto.customer.UpdateCustomerRequest;
import kh.edu.icstad.fsbankingapi.service.impl.CustomerServiceImplement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    private final CustomerServiceImplement customerService;

    @GetMapping()
    public BaseResponse<Object> findAllCustomers() {

        return BaseResponse
                .builder()
                .status(HttpStatus.OK.value())
                .timestamp(LocalDateTime.now())
                .message("Get All Customer")
                .data(customerService.findAllCustomers())
                .build();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public BaseResponse<Object> createCustomer(@Valid @RequestBody CreateCustomerRequest customerRequest) {
        return BaseResponse
                .builder()
                .status(HttpStatus.CREATED.value())
                .timestamp(LocalDateTime.now())
                .message("Create Customer")
                .data(customerService.createCustomer(customerRequest))
                .build();
    }

    @PatchMapping("/{email}")
    public BaseResponse<Object> updateCustomer(@PathVariable String email, @RequestBody UpdateCustomerRequest customerRequest) {
        return BaseResponse
                .builder()
                .status(HttpStatus.OK.value())
                .timestamp(LocalDateTime.now())
                .message("Create Customer")
                .data(customerService.updateCustomerByEmail(email, customerRequest))
                .build();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable String id) {
            customerService.deleteCustomerById(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{phone}")
    public void deleteCustomerByPhone(@PathVariable String phone) {
        customerService.deleteCustomerByPhone(phone);
    }
}
