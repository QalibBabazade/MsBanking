package com.example.msbanking.controller;

import com.example.msbanking.dto.requests.CardRequest;
import com.example.msbanking.dto.responses.CardResponse;
import com.example.msbanking.dto.responses.Response;
import com.example.msbanking.dto.responses.StatusAllResponse;
import com.example.msbanking.services.CardService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstanceWithVariables;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/card")
public class CardController {

    private final CardService cardService;

    private final RuntimeService runtimeService;

    public CardController(CardService cardService, RuntimeService runtimeService) {
        this.cardService = cardService;
        this.runtimeService = runtimeService;
    }

    @GetMapping(value = "/get-card/{cardId}")
    public Response<CardResponse> getOneCard(@PathVariable(required = false) Long cardId){
        return cardService.getOneCard(cardId);
    }

    @GetMapping(value = "/get-all-card")
    public Response<List<CardResponse>> getAllCard(){
        return cardService.getAllCard();
    }

    @PostMapping(value = "/add-card")
    public StatusAllResponse addCard(@RequestBody CardRequest cardRequest){
        ProcessInstanceWithVariables processInstanceWithVariables = runtimeService.createProcessInstanceByKey("CardAddProcess")
                .setVariable("cardRequest", cardRequest)
                .executeWithVariablesInReturn();
        return processInstanceWithVariables.getVariables().getValue("status",StatusAllResponse.class);
    }

    @PutMapping(value = "/update-card")
    public StatusAllResponse updateCard(@RequestBody CardRequest cardRequest){
        ProcessInstanceWithVariables processInstanceWithVariables = runtimeService.createProcessInstanceByKey("UpdateCardProcess")
                .setVariable("cardRequest", cardRequest)
                .executeWithVariablesInReturn();
        return processInstanceWithVariables.getVariables().getValue("status",StatusAllResponse.class);
    }

    @PutMapping(value = "/delete-card/{id}")
    public StatusAllResponse deleteCard(@PathVariable(required = false) Long id){
        return cardService.deleteCard(id);
    }
}
