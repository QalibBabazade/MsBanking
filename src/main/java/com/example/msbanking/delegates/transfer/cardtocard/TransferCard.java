package com.example.msbanking.delegates.transfer.cardtocard;

import com.example.msbanking.dto.requests.TransferCardRequest;
import com.example.msbanking.dto.responses.StatusAllResponse;
import com.example.msbanking.entities.Card;
import com.example.msbanking.services.TransferService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("transferCard")
public class TransferCard implements JavaDelegate {

    private final TransferService transferService;

    public TransferCard(TransferService transferService) {
        this.transferService = transferService;
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        TransferCardRequest request = (TransferCardRequest) execution.getVariable("requestCard");
        Card firstCard = (Card) execution.getVariable("firstCard");
        Card lastCard = (Card) execution.getVariable("lastCard");
        StatusAllResponse status = transferService.transferCard(firstCard,lastCard,request.getAmount());
        execution.setVariable("status",status);
    }
}
