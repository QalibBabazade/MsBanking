package com.example.msbanking.delegates.customer;

import com.example.msbanking.dto.responses.CustomerResponse;
import com.example.msbanking.dto.responses.Response;
import com.example.msbanking.services.CustomerService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.List;


@Component("customerGet")
public class CustomerGetAll implements JavaDelegate {

    private final CustomerService customerService;

    public CustomerGetAll(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        Long id = (Long) execution.getVariable("id");
        Response<List<CustomerResponse>> response = customerService.getAllCustomer(id);
        execution.setVariable("response",response);
    }
}
