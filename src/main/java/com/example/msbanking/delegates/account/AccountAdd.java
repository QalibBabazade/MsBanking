package com.example.msbanking.delegates.account;

import com.example.msbanking.dto.requests.AccountRequest;
import com.example.msbanking.dto.responses.StatusAllResponse;
import com.example.msbanking.services.AccountService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("addAccount")
public class AccountAdd implements JavaDelegate {

    private final AccountService accountService;

    public AccountAdd(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        AccountRequest accountRequest = (AccountRequest) execution.getVariable("accountRequest");
        StatusAllResponse status = (StatusAllResponse) accountService.addAccount(accountRequest);
        execution.setVariable("status",status);
    }
}
