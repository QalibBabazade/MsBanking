package com.example.msbanking.delegates.account;

import com.example.msbanking.dto.requests.AccountRequest;
import com.example.msbanking.dto.responses.StatusAllResponse;
import com.example.msbanking.entities.Account;
import com.example.msbanking.services.AccountService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("accountUpdate")
public class AccountUpdate implements JavaDelegate {

    private final AccountService accountService;

    public AccountUpdate(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        AccountRequest accountRequest = (AccountRequest) execution.getVariable("accountRequest");
        Account account = (Account) execution.getVariable("account");
        StatusAllResponse status = accountService.updateAccount(accountRequest,account);
        execution.setVariable("status",status);

    }


}
