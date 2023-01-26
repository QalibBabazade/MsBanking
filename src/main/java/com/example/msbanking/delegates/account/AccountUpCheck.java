package com.example.msbanking.delegates.account;

import com.example.msbanking.dto.requests.AccountRequest;
import com.example.msbanking.entities.Account;
import com.example.msbanking.services.AccountService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("accountUpCheck")
public class AccountUpCheck implements JavaDelegate {

    private final AccountService accountService;

    public AccountUpCheck(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        AccountRequest accountRequest = (AccountRequest) execution.getVariable("accountRequest");
        Account account = accountService.checkUpAccount(accountRequest);
        execution.setVariable("account",account);
    }
}
