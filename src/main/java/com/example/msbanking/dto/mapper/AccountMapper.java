package com.example.msbanking.dto.mapper;

import com.example.msbanking.dto.requests.AccountRequest;
import com.example.msbanking.dto.responses.AccountResponse;
import com.example.msbanking.entities.Account;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountMapper {

    AccountMapper ACCOUNT_MAPPER = Mappers.getMapper(AccountMapper.class);

    AccountResponse convertToAccountResponse(Account account);

    Account requestConvertToAccount(AccountRequest accountRequest);

    void update(@MappingTarget Account account, AccountRequest accountRequest);
}
