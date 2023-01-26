package com.example.msbanking.delegates.card;

import com.example.msbanking.dto.requests.CardRequest;
import com.example.msbanking.entities.Card;
import com.example.msbanking.services.CardService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("checkCardAvailable")
public class CardCheckAvailable implements JavaDelegate {

    private final CardService cardService;

    public CardCheckAvailable(CardService cardService) {
        this.cardService = cardService;
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        CardRequest cardRequest = (CardRequest) execution.getVariable("cardRequest");
        Card card = (Card) cardService.checkCardAvailable(cardRequest);
        execution.setVariable("card", card);

    }
}
