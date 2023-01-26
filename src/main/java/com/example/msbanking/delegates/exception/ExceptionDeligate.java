package com.example.msbanking.delegates.exception;

import com.example.msbanking.dto.responses.StatusAllResponse;
import com.example.msbanking.dto.responses.StatusResponse;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("exceptionHandler")
public class ExceptionDeligate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        Integer code =Integer.parseInt ((String) execution.getVariable("errorCode"));
        String message = (String) execution.getVariable("errorMessage");
        StatusAllResponse status = new StatusAllResponse(new StatusResponse(code,message));
        execution.setVariable("status",status);
    }
}
