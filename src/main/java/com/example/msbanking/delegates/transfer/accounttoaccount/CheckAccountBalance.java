package com.example.msbanking.delegates.transfer.accounttoaccount;

import com.example.msbanking.dto.requests.TransferAccountRequest;
import com.example.msbanking.entities.Account;
import com.example.msbanking.util.Utility;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("checkAccountBalance")
public class CheckAccountBalance implements JavaDelegate {

    private final Utility utility;

    public CheckAccountBalance(Utility utility) {
        this.utility = utility;
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {
      Account firstAccount  = (Account) execution.getVariable("firstAccount");
      TransferAccountRequest request = (TransferAccountRequest) execution.getVariable("requestAccount");
      boolean validate = utility.checkBalance(firstAccount.getBalance(),request.getAmount());
      execution.setVariable("validate",validate);

    }
}
