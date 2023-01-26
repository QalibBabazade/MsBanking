package com.example.msbanking.services.impl;

import com.example.msbanking.dto.mapper.CustomerMapper;
import com.example.msbanking.dto.requests.CustomerRequest;
import com.example.msbanking.dto.responses.CustomerResponse;
import com.example.msbanking.dto.responses.Response;
import com.example.msbanking.dto.responses.StatusAllResponse;
import com.example.msbanking.dto.responses.StatusResponse;
import com.example.msbanking.entities.Customer;
import com.example.msbanking.enums.EnumAvailableStatus;
import com.example.msbanking.enums.EnumError;
import com.example.msbanking.exception.BaseException;
import com.example.msbanking.repository.CustomerRepository;
import com.example.msbanking.services.CustomerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Response<List<CustomerResponse>> getAllCustomer(Long id) {

        Response<List<CustomerResponse>> response = new Response<>();
        List<Customer> customerList = new ArrayList<>();
        try {
            if (Optional.ofNullable(id).isPresent()) {
            Customer customer =  customerRepository.findCustomerByIdAndActive(id, EnumAvailableStatus.ACTIVE.getValue());
            customerList.add(customer);
            } else {
                customerList = customerRepository.findAllByActive(EnumAvailableStatus.ACTIVE.getValue());
            }
            List<CustomerResponse> customerResponseList = customerList.stream().map(customer -> CustomerMapper.CUSTOMER_MAPPER.convertCustomerResponse(customer)).collect(Collectors.toList());
            response.setT(customerResponseList);
            response.setStatusResponse(StatusResponse.getSuccessMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    @Override
    public Customer checkCustomer(CustomerRequest customerRequest) {
        String fin = customerRequest.getFin();
        Customer customer = customerRepository.findCustomerByFinAndActive(fin, EnumAvailableStatus.ACTIVE.getValue());
        return customer;
        /* throw new BaseException(EnumError.CUSTOMER_ALREADY_EXITS.getCode(), EnumError.CUSTOMER_ALREADY_EXITS.getMessage());*/
        /*  throw new BpmnError(EnumError.CUSTOMER_ALREADY_EXITS.getCode().toString(),EnumError.CUSTOMER_ALREADY_EXITS.getMessage());*/
    }

    @Override
    public StatusAllResponse addCustomer(CustomerRequest customerRequest) {
           /* Customer customer = new Customer();
            customer.setName(customerRequest.getName());
            customer.setSurname(customerRequest.getSurname());
            customer.setFatherName(customerRequest.getFatherName());
            customer.setAge(customerRequest.getAge());
            customer.setAddress(customer.getAddress());
            customer.setFin(customerRequest.getFin());
            customer.setVoen(customerRequest.getVoen());
            customer.setCustomerType(customerRequest.getCustomerType());*/

        Customer customer = CustomerMapper.CUSTOMER_MAPPER.convertToCustomer(customerRequest);
        customerRepository.save(customer);

        return new StatusAllResponse(StatusResponse.getSuccessMessage());
    }

    @Override
    public StatusAllResponse updateCustomer(Customer customer, CustomerRequest customerRequest) {
        CustomerMapper.CUSTOMER_MAPPER.update(customer,customerRequest);
        customerRepository.save(customer);
        return new StatusAllResponse(StatusResponse.getSuccessMessage());
    }

    @Override
    public StatusAllResponse deleteCustomer(Long id) {

        if(id == null){
            throw new BaseException(EnumError.INVALID_REQUEST_DATA.getCode(), EnumError.INVALID_REQUEST_DATA.getMessage());
        }
        Customer customer = customerRepository.findCustomerByIdAndActive(id,EnumAvailableStatus.ACTIVE.getValue());
        if(customer == null){
            throw new BaseException(EnumError.CUSTOMER_NOT_FOUND.getCode(),EnumError.CUSTOMER_NOT_FOUND.getMessage());
        }
        customer.setActive(0);
        customerRepository.save(customer);
        return new StatusAllResponse(StatusResponse.getSuccessMessage());
    }
}
