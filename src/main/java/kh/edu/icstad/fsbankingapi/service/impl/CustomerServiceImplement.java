package kh.edu.icstad.fsbankingapi.service.impl;

import kh.edu.icstad.fsbankingapi.dto.customer.CreateCustomerRequest;
import kh.edu.icstad.fsbankingapi.dto.customer.CustomerResponse;
import kh.edu.icstad.fsbankingapi.model.Customer;
import kh.edu.icstad.fsbankingapi.repository.CustomerRepository;
import kh.edu.icstad.fsbankingapi.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerServiceImplement implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public List<CustomerResponse> findAllCustomers() {
        List<CustomerResponse> customerList = new ArrayList<>();
        customerRepository.findAll().stream().map(customer -> {
            return customerList.add(CustomerResponse.builder()
                            .id(customer.getId())
                            .email(customer.getEmail())
                            .fullName(customer.getFullName())
                            .gender(customer.getGender())
                            .phoneNumber(customer.getPhoneNumber())
                    .build());
        }).toList();

        return customerList;
    }

    @Override
    public CustomerResponse createCustomer(CreateCustomerRequest createCustomerRequest) {
        if(customerRepository.existsByEmail(createCustomerRequest.email())){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email Already Exist");
        }

        if (customerRepository.existsByPhoneNumber(createCustomerRequest.phoneNumber())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Phone Number Already Exist");
        }

        Customer customer = new Customer();
        customer.setEmail(createCustomerRequest.email());
        customer.setFullName(createCustomerRequest.fullName());
        customer.setGender(createCustomerRequest.gender());
        customer.setPhoneNumber(createCustomerRequest.phoneNumber());

        customerRepository.save(customer);

        return CustomerResponse.builder()
                .id(customer.getId())
                .email(customer.getEmail())
                .fullName(customer.getFullName())
                .phoneNumber((customer.getPhoneNumber()))
                .gender(customer.getGender())
                .build();
    }
}
