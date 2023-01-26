package com.example.msbanking.services;


import com.example.msbanking.dto.responses.StatusAllResponse;
import com.example.msbanking.entities.Account;
import com.example.msbanking.entities.Card;

public interface TransferService {


    StatusAllResponse transferAccount(Account firstAccount, Account lastAccount, Double amount);

    StatusAllResponse transferCard(Card firstCard, Card lastCard, Double amount);
}
