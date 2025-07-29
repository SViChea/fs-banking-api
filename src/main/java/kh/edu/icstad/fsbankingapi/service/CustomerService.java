package kh.edu.icstad.fsbankingapi.service;

import kh.edu.icstad.fsbankingapi.dto.customer.CreateCustomerRequest;
import kh.edu.icstad.fsbankingapi.dto.customer.CustomerResponse;
import kh.edu.icstad.fsbankingapi.dto.customer.UpdateCustomerRequest;

import java.util.List;
import java.util.UUID;

public interface CustomerService {
    /**
     * Find All Customer
     * @return List of CustomerResponse
     */
    List<CustomerResponse> findAllCustomers();

    /**
     * Create Customer
     * @param createCustomerRequest
     * @return CustomerResponse
     */
    CustomerResponse createCustomer(CreateCustomerRequest createCustomerRequest);

    /**
     * Update Customer by Email
     * @param email
     * @param updateCustomerRequest
     * @return
     */
    CustomerResponse updateCustomerByEmail(String email,  UpdateCustomerRequest updateCustomerRequest);

    void deleteCustomerById(String id);

    void deleteCustomerByPhone(String phoneNumber);
}
