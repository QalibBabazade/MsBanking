package com.example.msbanking.delegates.transfer.cardtocard;

import com.example.msbanking.dto.requests.TransferCardRequest;
import com.example.msbanking.entities.Card;
import com.example.msbanking.services.AccountService;
import com.example.msbanking.util.Utility;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("checkCardBalance")
public class CheckCardBalance implements JavaDelegate {

    private final Utility utility;
    private final AccountService accountService;

    public CheckCardBalance(Utility utility, AccountService accountService) {
        this.utility = utility;
        this.accountService = accountService;
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        Card firstCard = (Card) execution.getVariable("firstCard");
        TransferCardRequest request = (TransferCardRequest) execution.getVariable("requestCard");
        boolean validate = utility.checkBalance(firstCard.getBalance(),firstCard.getAccount().getBalance(), request.getAmount());
        execution.setVariable("validate",validate);


    }
}
