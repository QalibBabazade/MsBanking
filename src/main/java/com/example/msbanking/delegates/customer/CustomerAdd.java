package com.example.msbanking.delegates.customer;

import com.example.msbanking.dto.requests.CustomerRequest;
import com.example.msbanking.dto.responses.StatusAllResponse;
import com.example.msbanking.services.CustomerService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("addCustomer")
public class CustomerAdd implements JavaDelegate {

    private final CustomerService customerService;

    public CustomerAdd(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        CustomerRequest customerRequest = (CustomerRequest) execution.getVariable("customerRequest");
        StatusAllResponse status = customerService.addCustomer(customerRequest);
        execution.setVariable("status",status);
    }
}
