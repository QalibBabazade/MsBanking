package com.example.msbanking.delegates.card;

import com.example.msbanking.dto.requests.CardRequest;
import com.example.msbanking.dto.responses.StatusAllResponse;
import com.example.msbanking.entities.Card;
import com.example.msbanking.services.CardService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("addCard")
public class CardAdd implements JavaDelegate {

    private final CardService cardService;

    public CardAdd(CardService cardService) {
        this.cardService = cardService;
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        CardRequest cardRequest = (CardRequest) execution.getVariable("cardRequest");
        Card card = (Card) execution.getVariable("card");
        StatusAllResponse status = cardService.addCard(card,cardRequest);
        execution.setVariable("status",status);
    }
}
