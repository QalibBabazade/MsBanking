package com.example.msbanking.delegates.account;

import com.example.msbanking.dto.requests.AccountRequest;
import com.example.msbanking.services.AccountService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("accountCheck")
public class AccountCheck implements JavaDelegate {

    private final AccountService accountService;

    public AccountCheck(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        AccountRequest accountRequest = (AccountRequest) execution.getVariable("accountRequest");
        boolean accountIsExits = (boolean) accountService.checkAccount(accountRequest);
        execution.setVariable("accountIsExits", accountIsExits);
    }
}
