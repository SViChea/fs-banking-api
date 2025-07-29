package kh.edu.icstad.fsbankingapi.repository;

import kh.edu.icstad.fsbankingapi.dto.customer.CreateCustomerRequest;
import kh.edu.icstad.fsbankingapi.dto.customer.CustomerResponse;
import kh.edu.icstad.fsbankingapi.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    List<Customer> findByIsDeleted(Boolean isDeleted);

    Boolean existsByEmail(String email);

    Boolean existsByPhoneNumber(String phoneNumber);

    Optional<Customer> findCustomerByEmail(String email);

    Optional<Customer> findCustomerById(String id);

    Optional<Customer> findCustomerByPhoneNumber(String phoneNumber);
}
