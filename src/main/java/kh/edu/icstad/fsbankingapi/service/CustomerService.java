package kh.edu.icstad.fsbankingapi.service;

import kh.edu.icstad.fsbankingapi.dto.customer.CreateCustomerRequest;
import kh.edu.icstad.fsbankingapi.dto.customer.CustomerResponse;

import java.util.List;

public interface CustomerService {
    /**
     * Find All Customer
     * @return List of CustomerResponse
     */
    List<CustomerResponse> findAllCustomers();

    /**
     * Create Customer
     * @param fullName
     * @param email
     * @param phoneNumber
     * @param gender
     * @return CustomerResponse
     */
    CustomerResponse createCustomer(CreateCustomerRequest createCustomerRequest);
}
