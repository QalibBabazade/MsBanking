package com.example.msbanking.controller;

import com.example.msbanking.dto.requests.TransferAccountRequest;
import com.example.msbanking.dto.requests.TransferCardRequest;
import com.example.msbanking.dto.responses.StatusAllResponse;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstanceWithVariables;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/transfer")
public class TransferController {

    private RuntimeService runtimeService;

    public TransferController(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    @PostMapping(value = "/account-to-account")
    public StatusAllResponse transferAccount(@RequestBody TransferAccountRequest request){
        ProcessInstanceWithVariables processInstanceWithVariables = runtimeService.createProcessInstanceByKey("AccountToAccountProcess")
                .setVariable("requestAccount", request)
                .executeWithVariablesInReturn();
        return processInstanceWithVariables.getVariables().getValue("status",StatusAllResponse.class);
    }

    @PostMapping(value = "/card-to-card")
    public StatusAllResponse transferCard(@RequestBody TransferCardRequest request){
        ProcessInstanceWithVariables processInstanceWithVariables = runtimeService.createProcessInstanceByKey("CardToCardProcess")
                .setVariable("requestCard", request)
                .executeWithVariablesInReturn();
        return processInstanceWithVariables.getVariables().getValue("status",StatusAllResponse.class);

    }
}
