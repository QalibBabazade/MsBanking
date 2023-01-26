package com.example.msbanking.services;

import com.example.msbanking.dto.requests.CustomerRequest;
import com.example.msbanking.dto.responses.CustomerResponse;
import com.example.msbanking.dto.responses.Response;
import com.example.msbanking.dto.responses.StatusAllResponse;
import com.example.msbanking.entities.Customer;

import java.util.List;


public interface CustomerService {

    Response<List<CustomerResponse>> getAllCustomer(Long id);

    Customer checkCustomer(CustomerRequest customerRequest);

    StatusAllResponse addCustomer(CustomerRequest customerRequest);

    StatusAllResponse updateCustomer(Customer customer,CustomerRequest customerRequest);

    StatusAllResponse deleteCustomer(Long id);
}
