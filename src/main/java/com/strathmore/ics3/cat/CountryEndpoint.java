package com.strathmore.ics3.cat;

import com.strathmore.ics3.cat.repository.CountryRepository;
import localhost._8080.webservice.GetCountryRequest;
import localhost._8080.webservice.GetCountryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * Created by clive on 18/10/17.
 */
    @Endpoint
    public class CountryEndpoint {
        private static final String NAMESPACE_URI = "http://localhost:8080/webservice";

        private CountryRepository countryRepository;

        @Autowired
        public CountryEndpoint(CountryRepository countryRepository) {
            this.countryRepository = countryRepository;
        }

        @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
        @ResponsePayload
        public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
            GetCountryResponse response = new GetCountryResponse();
            response.setCountry(countryRepository.findCountry(request.getName()));

            return response;
        }
    }

