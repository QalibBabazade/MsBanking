package com.example.msbanking.delegates.customer;

import com.example.msbanking.dto.requests.CustomerRequest;
import com.example.msbanking.util.Utility;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("checkCustomerRequestData")
public class CustomerCheckRequestData implements JavaDelegate {

    private final Utility utility;

    public CustomerCheckRequestData(Utility utility) {
        this.utility = utility;
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        CustomerRequest customerRequest = (CustomerRequest) execution.getVariable("customerRequest");
        utility.checkCustomerRequestData(customerRequest);
    }
}
