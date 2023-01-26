package com.example.msbanking.delegates.account;

import com.example.msbanking.dto.requests.AccountRequest;
import com.example.msbanking.util.Utility;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("checkRequestData")
public class CheckRequestData implements JavaDelegate {


private final Utility utility;

    public CheckRequestData( Utility utility) {
        this.utility = utility;
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        AccountRequest accountRequest = (AccountRequest) execution.getVariable("accountRequest");
        utility.checkAccountRequestData(accountRequest);
        utility.checkCustomer(accountRequest.getCustomer().getId());

    }
}
