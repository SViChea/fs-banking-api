package kh.edu.icstad.fsbankingapi.service.impl;

import kh.edu.icstad.fsbankingapi.dto.customer.CreateCustomerRequest;
import kh.edu.icstad.fsbankingapi.dto.customer.CustomerResponse;
import kh.edu.icstad.fsbankingapi.mapper.CustomerMapper;
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
    private final CustomerMapper customerMapper;

    @Override
    public List<CustomerResponse> findAllCustomers() {
        List<Customer> customerList = customerRepository.findAll();

        return customerMapper.toCustomerResponseList(customerList);
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

        return customerMapper.toCustomerResponse(customer);
    }
}
