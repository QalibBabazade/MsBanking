package com.example.msbanking.services.impl;

import com.example.msbanking.dto.mapper.AccountMapper;
import com.example.msbanking.dto.requests.AccountRequest;
import com.example.msbanking.dto.responses.AccountResponse;
import com.example.msbanking.dto.responses.Response;
import com.example.msbanking.dto.responses.StatusAllResponse;
import com.example.msbanking.dto.responses.StatusResponse;
import com.example.msbanking.entities.Account;
import com.example.msbanking.enums.EnumAvailableStatus;
import com.example.msbanking.enums.EnumError;
import com.example.msbanking.exception.BaseException;
import com.example.msbanking.repository.AccountRepository;
import com.example.msbanking.services.AccountService;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Response<AccountResponse> getOneAccount(Long id) {
        Response<AccountResponse> response = new Response<>();
        if (id == null) {
            throw new BaseException(EnumError.INVALID_REQUEST_DATA.getCode(), EnumError.INVALID_REQUEST_DATA.getMessage());
        }

        Account account = accountRepository.findAccountByIdAndActive(id, EnumAvailableStatus.ACTIVE.getValue());

        if (account == null) {
            throw new BaseException(EnumError.ACCOUNT_NOT_FOUND.getCode(), EnumError.ACCOUNT_NOT_FOUND.getMessage());
        }

        AccountResponse accountResponse = AccountMapper.ACCOUNT_MAPPER.convertToAccountResponse(account);
        response.setT(accountResponse);
        response.setStatusResponse(StatusResponse.getSuccessMessage());
        return response;
    }

    @Override
    public Response<List<AccountResponse>> getAllAccount() {

        Response<List<AccountResponse>> response = new Response<>();

        List<Account> accountList = accountRepository.findAllByActive(EnumAvailableStatus.ACTIVE.getValue());

        List<AccountResponse> accountResponseList = accountList.stream().map(AccountMapper.ACCOUNT_MAPPER::convertToAccountResponse).collect(Collectors.toList());

       response.setT(accountResponseList);
       response.setStatusResponse(StatusResponse.getSuccessMessage());

        return response;
    }

    @Override
    public boolean checkAccount(AccountRequest accountRequest) {
        List<Account> accountList =  accountRepository.findAccountByIbanOrNumberAndActive(accountRequest.getIban(),accountRequest.getNumber(),EnumAvailableStatus.ACTIVE.getValue());
        if(!accountList.isEmpty()){
            return false;
        }
        return true;
    }


    @Override
    public StatusAllResponse addAccount(AccountRequest accountRequest) {
      Account account = AccountMapper.ACCOUNT_MAPPER.requestConvertToAccount(accountRequest);
      accountRepository.save(account);
        return new StatusAllResponse(StatusResponse.getSuccessMessage());
    }

    @Override
    public StatusAllResponse updateAccount(AccountRequest accountRequest, Account account) {

        AccountMapper.ACCOUNT_MAPPER.update(account,accountRequest);
        accountRepository.save(account);
        return new StatusAllResponse(StatusResponse.getSuccessMessage());
    }


    @Override
    public Account checkUpAccount(AccountRequest accountRequest) {
        Account account = accountRepository.findAccountByIbanAndActive(accountRequest.getIban(),EnumAvailableStatus.ACTIVE.getValue());

        return account;
    }

    @Override
    public StatusAllResponse deleteAccount(Long id) {
        Account account = accountRepository.findAccountByIdAndActive(id,EnumAvailableStatus.ACTIVE.getValue());
        account.setActive(0);
        accountRepository.save(account);
        return new StatusAllResponse(StatusResponse.getSuccessMessage());
    }


}
