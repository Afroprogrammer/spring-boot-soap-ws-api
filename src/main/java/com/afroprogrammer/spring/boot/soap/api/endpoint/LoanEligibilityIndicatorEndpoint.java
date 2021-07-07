package com.afroprogrammer.spring.boot.soap.api.endpoint;

import com.afroprogrammer.spring.boot.soap.api.loaneligibility.Acknowledgement;
import com.afroprogrammer.spring.boot.soap.api.loaneligibility.CustomerRequest;
import com.afroprogrammer.spring.boot.soap.api.service.loanEligibilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class LoanEligibilityIndicatorEndpoint {

    private static final String NAMESPACE="http://www.afroprogrammer.com/spring/boot/soap/api/loanEligibility";


    @Autowired
    private loanEligibilityService service;

    @PayloadRoot(namespace = NAMESPACE, localPart = "CustomerRequest")
    @ResponsePayload
    public Acknowledgement getLoanStatus(@RequestPayload CustomerRequest request)
    {
        return service.checkLoanEligibility( request );
    }
}
