package com.ibandla.soap.client;

import countries.wsdl.GetCountryRequest;
import countries.wsdl.GetCountryResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.soap.client.core.SoapActionCallback;

/**
 * Created by clive on 01/11/17.
 */


public class CountryClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(CountryClient.class);

    public GetCountryResponse getCountry(String name) {

        GetCountryRequest request = new GetCountryRequest();
        request.setName(name);

        log.info("Requesting quote for " + name);

        GetCountryResponse response = (GetCountryResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws",
                        request,
                        new SoapActionCallback("http://localhost:8080/webservice"));

        return response;
    }

}