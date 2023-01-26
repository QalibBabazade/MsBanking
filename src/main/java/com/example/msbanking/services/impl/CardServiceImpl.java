package com.example.msbanking.services.impl;

import com.example.msbanking.dto.mapper.CardMapper;
import com.example.msbanking.dto.requests.CardRequest;
import com.example.msbanking.dto.responses.CardResponse;
import com.example.msbanking.dto.responses.Response;
import com.example.msbanking.dto.responses.StatusAllResponse;
import com.example.msbanking.dto.responses.StatusResponse;
import com.example.msbanking.entities.Card;
import com.example.msbanking.enums.EnumAvailableStatus;
import com.example.msbanking.enums.EnumError;
import com.example.msbanking.exception.BaseException;
import com.example.msbanking.repository.CardRepository;
import com.example.msbanking.services.CardService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;

    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public Response<CardResponse> getOneCard(Long id) {

        Response<CardResponse> response = new Response<>();
        if (id == null) {
            throw new BaseException(EnumError.INVALID_REQUEST_DATA.getCode(), EnumError.INVALID_REQUEST_DATA.getMessage());
        }
        Card card = cardRepository.findCardByIdAndActive(id, EnumAvailableStatus.ACTIVE.getValue());
        if (card == null) {
            throw new BaseException(EnumError.CARD_NOT_FOUND.getCode(), EnumError.CARD_NOT_FOUND.getMessage());
        }
        CardResponse cardResponse = CardMapper.CARD_MAPPER.convertCardResponse(card);
        response.setT(cardResponse);
        response.setStatusResponse(StatusResponse.getSuccessMessage());

        return response;
    }

    @Override
    public Response<List<CardResponse>> getAllCard() {
        Response<List<CardResponse>> response = new Response<>();
        List<Card> cardList = cardRepository.findAllByActive(EnumAvailableStatus.ACTIVE.getValue());
        if (cardList.isEmpty()) {
            throw new BaseException(EnumError.CARD_NOT_FOUND.getCode(), EnumError.CARD_NOT_FOUND.getMessage());
        }
        List<CardResponse> cardResponseList = cardList.stream().map(CardMapper.CARD_MAPPER::convertCardResponse).collect(Collectors.toList());
        response.setT(cardResponseList);
        response.setStatusResponse(StatusResponse.getSuccessMessage());
        return response;
    }

    @Override
    public Card checkCardAvailable(CardRequest cardRequest) {
        Card card = cardRepository.findCardByNumberAndActive(cardRequest.getNumber(),EnumAvailableStatus.ACTIVE.getValue());
        return card;
    }

    @Override
    public StatusAllResponse addCard(Card card, CardRequest cardRequest) {
       card =  CardMapper.CARD_MAPPER.convertToCard(cardRequest);
       cardRepository.save(card);
        return new StatusAllResponse(StatusResponse.getSuccessMessage());
    }

    @Override
    public StatusAllResponse updateCard(Card card, CardRequest cardRequest) {
        CardMapper.CARD_MAPPER.update(card,cardRequest);
        cardRepository.save(card);
        return new StatusAllResponse(StatusResponse.getSuccessMessage());
    }

    @Override
    public StatusAllResponse deleteCard(Long id) {
        Card card = cardRepository.findCardByIdAndActive(id,EnumAvailableStatus.ACTIVE.getValue());
        card.setActive(0);
        cardRepository.save(card);
        return new StatusAllResponse(StatusResponse.getSuccessMessage());
    }


}
