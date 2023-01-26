package com.example.msbanking.delegates.customer;

import com.example.msbanking.dto.requests.CustomerRequest;
import com.example.msbanking.entities.Customer;
import com.example.msbanking.services.CustomerService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;


@Component("checkCustomer")
public class CustomerCheck implements JavaDelegate {

    private final CustomerService customerService;

    public CustomerCheck(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        CustomerRequest customerRequest = (CustomerRequest) execution.getVariable("customerRequest");
        Customer customer =(Customer) customerService.checkCustomer(customerRequest);
        execution.setVariable("customer",customer);


    }
}
