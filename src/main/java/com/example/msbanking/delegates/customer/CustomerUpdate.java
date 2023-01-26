package com.example.msbanking.delegates.customer;

import com.example.msbanking.dto.requests.CustomerRequest;
import com.example.msbanking.dto.responses.StatusAllResponse;
import com.example.msbanking.entities.Customer;
import com.example.msbanking.services.CustomerService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("customerUpdate")
public class CustomerUpdate implements JavaDelegate {

    private final CustomerService customerService;

    public CustomerUpdate(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        Customer customer = (Customer) execution.getVariable("customer");
        CustomerRequest customerRequest = (CustomerRequest) execution.getVariable("customerRequest");
        StatusAllResponse status = customerService.updateCustomer(customer,customerRequest);
        execution.setVariable("status",status);
    }
}
