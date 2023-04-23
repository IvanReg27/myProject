package com.vkatit;

import com.vkatit.model.Country;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.CoreMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {
    @LocalServerPort
    int randomPort;
    RestTemplate restTemplate;
    @BeforeEach
    public void init() {
        restTemplate = new RestTemplate();
    }
    @Autowired
    Environment environment;
    @Autowired
    ApplicationContext applicationContext;
    @Test
    void contextLoads() {
        MatcherAssert.assertThat(applicationContext, is(notNullValue()));
    }
    @Test
    public void testCountries() {
        Country[] countries = restTemplate.getForObject("http://localhost:" + randomPort + "/countries", Country[].class);
        MatcherAssert.assertThat(countries, is(notNullValue()));
        MatcherAssert.assertThat(countries.length, is(equalTo(6)));
    }
}