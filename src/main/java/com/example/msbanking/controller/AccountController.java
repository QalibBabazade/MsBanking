package com.example.msbanking.controller;

import com.example.msbanking.dto.requests.AccountRequest;
import com.example.msbanking.dto.responses.AccountResponse;
import com.example.msbanking.dto.responses.Response;
import com.example.msbanking.dto.responses.StatusAllResponse;
import com.example.msbanking.services.AccountService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstanceWithVariables;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/account")
public class AccountController {

    private final RuntimeService runtimeService;

    private final AccountService accountService;

    public AccountController(RuntimeService runtimeService, AccountService accountService) {
        this.runtimeService = runtimeService;
        this.accountService = accountService;
    }

    @GetMapping(value = "get-account/{id}")
    public Response<AccountResponse> getOneAccount(@PathVariable Long id) {
        return accountService.getOneAccount(id);
    }

    @GetMapping(value = "get-all-account")
    public Response<List<AccountResponse>> getAllAccount() {
        return accountService.getAllAccount();
    }

    @PostMapping(value = "/add-account")
    public StatusAllResponse addAccount(@RequestBody AccountRequest accountRequest) {
        ProcessInstanceWithVariables processInstanceWithVariables = runtimeService.createProcessInstanceByKey("AccountAddProcess")
                .setVariable("accountRequest",accountRequest)
                .executeWithVariablesInReturn();
        return processInstanceWithVariables.getVariables().getValue("status",StatusAllResponse.class);
    }

    @PutMapping(value = "/update-account")
    public StatusAllResponse updateAccount(@RequestBody AccountRequest accountRequest) {
        ProcessInstanceWithVariables processInstanceWithVariables = runtimeService.createProcessInstanceByKey("UpdateAccountProcess")
                .setVariable("accountRequest", accountRequest)
                .executeWithVariablesInReturn();
        return processInstanceWithVariables.getVariables().getValue("status",StatusAllResponse.class);
    }

    @PutMapping(value = "delete-account/{id}")
    public StatusAllResponse deleteAccount(@PathVariable Long id) {
        return accountService.deleteAccount(id);
    }
}
