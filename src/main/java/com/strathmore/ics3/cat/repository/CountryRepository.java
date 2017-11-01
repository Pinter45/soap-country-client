package com.strathmore.ics3.cat.repository;

import localhost._8080.webservice.Country;
import localhost._8080.webservice.Currency;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by clive on 18/10/17.
 */
@Component
public class CountryRepository {

    private  static final Map<String,Country> countries = new HashMap<>();

    @PostConstruct
    public  void  initData(){
        Country spain = new Country();
        spain.setName("Spain");
        spain.setCapital("Madrid");
        spain.setCurrency(Currency.EUR);
        spain.setPopulation(3423423);
        countries.put(spain.getName(),spain);
        Country uk = new Country();

        uk.setName("uk");
        uk.setCapital("asdasda");
        uk.setCurrency(Currency.GBP);
        uk.setPopulation(3423423);
        countries.put(uk.getName(),uk);

        Country poland = new Country();
        poland.setName("Poland");
        poland.setCapital("Landa");
        poland.setCurrency(Currency.PLN);
        poland.setPopulation(435233);
        countries.put(poland.getName(),poland);

    }

    public Country findCountry(String name) {
        Assert.notNull(name,"the cot");
        return  countries.get(name);

    }

}
