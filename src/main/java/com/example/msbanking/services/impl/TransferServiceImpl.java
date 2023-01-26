package com.example.msbanking.services.impl;

import com.example.msbanking.dto.responses.StatusAllResponse;
import com.example.msbanking.dto.responses.StatusResponse;
import com.example.msbanking.entities.Account;
import com.example.msbanking.entities.Card;
import com.example.msbanking.entities.Transfer;
import com.example.msbanking.enums.CurrencyEnum;
import com.example.msbanking.enums.EnumAvailableStatus;
import com.example.msbanking.enums.StatusEnum;
import com.example.msbanking.enums.EnumTransferType;
import com.example.msbanking.repository.AccountRepository;
import com.example.msbanking.repository.CardRepository;
import com.example.msbanking.repository.TransferRespository;
import com.example.msbanking.services.TransferService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
public class
TransferServiceImpl implements TransferService {

    private final TransferRespository transferRespository;

    private final AccountRepository accountRepository;

    private final CardRepository cardRepository;


    public TransferServiceImpl(TransferRespository transferRespository, AccountRepository accountRepository,
                               CardRepository cardRepository) {
        this.transferRespository = transferRespository;
        this.accountRepository = accountRepository;
        this.cardRepository = cardRepository;
    }

    @Override
    public StatusAllResponse transferAccount(Account firstAccount, Account lastAccount, Double amount) {
        Double firstBalance = firstAccount.getBalance().doubleValue() - amount;
        Double lastBalance = lastAccount.getBalance().doubleValue() + amount;
        firstAccount.setBalance(BigDecimal.valueOf(firstBalance));
        accountRepository.save(firstAccount);
        lastAccount.setBalance(BigDecimal.valueOf(lastBalance));
        accountRepository.save(lastAccount);
        Long creditorAccountId = firstAccount.getId();
        CurrencyEnum creditorCurrency = firstAccount.getCurrency();
        Long debitorAccountId = lastAccount.getId();
        CurrencyEnum debitorCurrency = lastAccount.getCurrency();
        Transfer transfer = new Transfer();
        transfer.setCreditorAccountId(creditorAccountId);
        transfer.setCreditorAmount(amount);
        transfer.setCreditorCurrency(creditorCurrency);
        transfer.setDebitorAccountId(debitorAccountId);
        transfer.setDebitorAmount(amount);
        transfer.setDebitorCurrency(debitorCurrency);
        transfer.setStatus(StatusEnum.ACTIVE);
        transfer.setTransferType(EnumTransferType.ACCOUNT_TO_ACCOUNT);
        transferRespository.save(transfer);
        return new StatusAllResponse(StatusResponse.getSuccessMessage());
    }

    @Override
    public StatusAllResponse transferCard(Card firstCard, Card lastCard, Double amount) {
        firstCard.setBalance(BigDecimal.valueOf(firstCard.getBalance().doubleValue() - amount));
        Account firstAccount = accountRepository.findAccountByIdAndActive(firstCard.getAccount().getId(), EnumAvailableStatus.ACTIVE.getValue());
        firstAccount.setBalance(BigDecimal.valueOf(firstCard.getAccount().getBalance().doubleValue() - amount));
        lastCard.setBalance(BigDecimal.valueOf(lastCard.getBalance().doubleValue() + amount));
        Account lastAccount = accountRepository.findAccountByIdAndActive(lastCard.getAccount().getId(),EnumAvailableStatus.ACTIVE.getValue());
        lastAccount.setBalance(BigDecimal.valueOf(lastCard.getAccount().getBalance().doubleValue() + amount));
        cardRepository.save(firstCard);
        cardRepository.save(lastCard);
        accountRepository.save(firstAccount);
        accountRepository.save(lastAccount);
        Long creditorCardId = firstCard.getId();
        CurrencyEnum creditorCurrency = firstCard.getCurrency();
        Long creditorAccountId = firstCard.getAccount().getId();
        Long debitorCardId = lastCard.getId();
        CurrencyEnum debitorCurrency = lastCard.getCurrency();
        Long debitorAccountId = lastCard.getAccount().getId();
        Transfer transfer = new Transfer();
        transfer.setCreditorCardId(creditorCardId);
        transfer.setCreditorAccountId(creditorAccountId);
        transfer.setCreditorAmount(amount);
        transfer.setCreditorCurrency(creditorCurrency);
        transfer.setDebitorCardId(debitorCardId);
        transfer.setDebitorAccountId(debitorAccountId);
        transfer.setDebitorAmount(amount);
        transfer.setDebitorCurrency(debitorCurrency);
        transfer.setStatus(StatusEnum.ACTIVE);
        transfer.setTransferType(EnumTransferType.CARD_TO_CARD);
        transferRespository.save(transfer);

        return new StatusAllResponse(StatusResponse.getSuccessMessage());
    }
}
