package com.example.msbanking.delegates.transfer.cardtocard;

import com.example.msbanking.dto.requests.CardRequest;
import com.example.msbanking.dto.requests.TransferCardRequest;
import com.example.msbanking.entities.Card;
import com.example.msbanking.services.CardService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("checkFirstCard")
public class CheckFirstCard implements JavaDelegate {

    private final CardService cardService;

    public CheckFirstCard(CardService cardService) {
        this.cardService = cardService;
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {

       TransferCardRequest request = (TransferCardRequest) execution.getVariable("requestCard");
       CardRequest cardRequest = new CardRequest();
       cardRequest.setNumber(request.getFirstCardNumber());
       Card firstCard = (Card) cardService.checkCardAvailable(cardRequest);
       execution.setVariable("firstCard",firstCard);

    }
}
