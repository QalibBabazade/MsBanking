package com.example.msbanking.services;

import com.example.msbanking.dto.requests.AccountRequest;
import com.example.msbanking.dto.responses.AccountResponse;
import com.example.msbanking.dto.responses.Response;
import com.example.msbanking.dto.responses.StatusAllResponse;
import com.example.msbanking.entities.Account;

import java.util.List;

public interface AccountService {

    Response<AccountResponse> getOneAccount(Long id);

    Response<List<AccountResponse>> getAllAccount();

    boolean checkAccount(AccountRequest accountRequest);

    StatusAllResponse addAccount(AccountRequest accountRequest);

    StatusAllResponse updateAccount(AccountRequest accountRequest, Account account);

    Account checkUpAccount(AccountRequest accountRequest);

    StatusAllResponse deleteAccount(Long id);


}
