package com.strathmore.ics3.cat;

import com.strathmore.ics3.cat.client.CountryClient;
import localhost._8080.webservice.Country;
import localhost._8080.webservice.GetCountryResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner lookup(CountryClient countryClient) {
		return args -> {
			String name = "Spain";

			if (args.length > 0) {
				name = args[0];
			}
			countries.wsdl.GetCountryResponse response = countryClient.getCountry(name);
			countries.wsdl.Country country = response.getCountry();

			String result = country.getName() + "\n" + country.getCapital()  + "\n" +
					country.getCurrency() + "\n" + country.getPopulation();

			System.err.println(result);
		};
	}

}
