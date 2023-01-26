package com.example.msbanking.delegates.transfer.accounttoaccount;

import com.example.msbanking.dto.requests.TransferAccountRequest;
import com.example.msbanking.dto.responses.StatusAllResponse;
import com.example.msbanking.entities.Account;
import com.example.msbanking.services.TransferService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("transferAccount")
public class TransferAccount implements JavaDelegate {

    private final TransferService transferService;

    public TransferAccount(TransferService transferService) {
        this.transferService = transferService;
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        Account firstAccount  = (Account) execution.getVariable("firstAccount");
        Account lastAccount  = (Account) execution.getVariable("lastAccount");
        TransferAccountRequest request = (TransferAccountRequest) execution.getVariable("requestAccount");
        StatusAllResponse status = transferService.transferAccount(firstAccount,lastAccount,request.getAmount());
        execution.setVariable("status",status);
    }
}
