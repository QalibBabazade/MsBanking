package com.example.msbanking.delegates.card;

import com.example.msbanking.dto.requests.CardRequest;
import com.example.msbanking.util.Utility;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("checkCardRequestData")
public class CardCheckRequestData implements JavaDelegate {

    private final Utility utility;

    public CardCheckRequestData(Utility utility) {
        this.utility = utility;
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        CardRequest cardRequest = (CardRequest) execution.getVariable("cardRequest");
        utility.checkCardRequestData(cardRequest);
    }
}
