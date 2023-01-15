package com.vkatit;

import static org.hamcrest.CoreMatchers.*;

import com.vkatit.model.Country;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.CoreMatchers.notNullValue;

@SpringBootTest
class DemoApplicationTests {

	RestTemplate restTemplate;

	@BeforeEach
	public void init(){
		restTemplate = new RestTemplate();
	}

	@Autowired
	AppContext appContext;

	@Test
	void contextLoads() {
		MatcherAssert.assertThat(appContext, is(notNullValue()));
	}

	@Test
	public void testCountries(){
		Country[] countries = restTemplate.getForObject("http://localhost:8080/countries", Country[].class);
		MatcherAssert.assertThat(countries, is(notNullValue()));
		MatcherAssert.assertThat(countries.length, is(equalTo(6)));
	}

}
