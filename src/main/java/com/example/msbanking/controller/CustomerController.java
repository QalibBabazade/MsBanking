package com.example.msbanking.controller;

import com.example.msbanking.dto.requests.CustomerRequest;
import com.example.msbanking.dto.responses.CustomerResponse;
import com.example.msbanking.dto.responses.Response;
import com.example.msbanking.dto.responses.StatusAllResponse;
import com.example.msbanking.services.CustomerService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstanceWithVariables;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="/customer")
public class CustomerController {

    private final RuntimeService runtimeService;

    private final CustomerService customerService;


    public CustomerController(RuntimeService runtimeService, CustomerService customerService) {
        this.runtimeService = runtimeService;
        this.customerService = customerService;
    }

    @GetMapping(value = "/get-customer")
    public Response<List<CustomerResponse>> getAllCustomer(@RequestParam(required = false,value = "id") Long id){
        ProcessInstanceWithVariables processInstanceWithVariables = runtimeService
                .createProcessInstanceByKey("getAllCustomerProcess").setVariable("id",id)
                .executeWithVariablesInReturn();
        return processInstanceWithVariables.getVariables().getValue("response",Response.class);
    }

    @PostMapping(value = "/add-customer")
    public StatusAllResponse addCustomer(@RequestBody CustomerRequest customerRequest){
        ProcessInstanceWithVariables processInstanceWithVariables = runtimeService
                .createProcessInstanceByKey("customerSaveProcess").setVariable("customerRequest",customerRequest)
                .executeWithVariablesInReturn();
        return processInstanceWithVariables.getVariables().getValue("status",StatusAllResponse.class);
    }

    @PutMapping(value = "/update-customer")
    public StatusAllResponse updateCustomer(@RequestBody CustomerRequest customerRequest ){
        ProcessInstanceWithVariables processInstanceWithVariables = runtimeService
                .createProcessInstanceByKey("customerUpdateProcces")
                .setVariable("customerRequest", customerRequest)
                .executeWithVariablesInReturn();
        return  processInstanceWithVariables.getVariables().getValue("status",StatusAllResponse.class);
    }

    @PutMapping(value = "/delete-customer/{id}")
    public StatusAllResponse deleteCustomer(@PathVariable(required = true) Long id){
        return customerService.deleteCustomer(id);
    }




}
