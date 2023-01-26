package com.example.msbanking.delegates.transfer.accounttoaccount;

import com.example.msbanking.dto.requests.AccountRequest;
import com.example.msbanking.dto.requests.TransferAccountRequest;
import com.example.msbanking.entities.Account;
import com.example.msbanking.services.AccountService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("checkFirstAccount")
public class CheckFirstAccount implements JavaDelegate {

    private final AccountService accountService;

    public CheckFirstAccount(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {
     TransferAccountRequest request = (TransferAccountRequest) execution.getVariable("requestAccount");
        AccountRequest accountRequest = new AccountRequest();
        accountRequest.setIban(request.getFirstAccountIban());
        Account firstAccount = accountService.checkUpAccount(accountRequest);
        execution.setVariable("firstAccount",firstAccount);
    }
}
