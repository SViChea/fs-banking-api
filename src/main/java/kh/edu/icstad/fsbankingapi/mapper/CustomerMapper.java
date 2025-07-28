package kh.edu.icstad.fsbankingapi.mapper;

import kh.edu.icstad.fsbankingapi.dto.customer.CustomerResponse;
import kh.edu.icstad.fsbankingapi.dto.customer.UpdateCustomerRequest;
import kh.edu.icstad.fsbankingapi.model.Customer;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper{

    @BeanMapping(nullValuePropertyMappingStrategy =  NullValuePropertyMappingStrategy.IGNORE)
    void toCustomerPartial(UpdateCustomerRequest request, @MappingTarget Customer customer);

    CustomerResponse toCustomerResponse(Customer customer);

    List<CustomerResponse> toCustomerResponseList(List<Customer> customerList);
}
