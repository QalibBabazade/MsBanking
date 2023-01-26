package com.example.msbanking.dto.mapper;

import com.example.msbanking.dto.requests.CustomerRequest;
import com.example.msbanking.dto.responses.CustomerResponse;
import com.example.msbanking.entities.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper CUSTOMER_MAPPER = Mappers.getMapper(CustomerMapper.class);

    CustomerResponse convertCustomerResponse(Customer customer);

    Customer convertToCustomer(CustomerRequest customerRequest);

    void update(@MappingTarget Customer customer, CustomerRequest customerRequest);
}
