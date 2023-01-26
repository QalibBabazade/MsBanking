package com.example.msbanking.services;

import com.example.msbanking.dto.requests.CardRequest;
import com.example.msbanking.dto.responses.CardResponse;
import com.example.msbanking.dto.responses.Response;
import com.example.msbanking.dto.responses.StatusAllResponse;
import com.example.msbanking.entities.Card;

import java.util.List;

public interface CardService {


    Response<CardResponse> getOneCard(Long id);

    Response<List<CardResponse>> getAllCard();

    Card checkCardAvailable(CardRequest cardRequest);

    StatusAllResponse addCard(Card card, CardRequest cardRequest);

    StatusAllResponse updateCard(Card card, CardRequest cardRequest);

    StatusAllResponse deleteCard(Long id);
}
