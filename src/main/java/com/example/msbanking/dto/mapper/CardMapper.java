package com.example.msbanking.dto.mapper;

import com.example.msbanking.dto.requests.CardRequest;
import com.example.msbanking.dto.responses.CardResponse;
import com.example.msbanking.entities.Card;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CardMapper {

    CardMapper CARD_MAPPER = Mappers.getMapper(CardMapper.class);

    CardResponse convertCardResponse(Card card);

    Card convertToCard(CardRequest cardRequest);

    void update(@MappingTarget Card card, CardRequest cardRequest);
}
