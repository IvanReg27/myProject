package com.vkatit;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

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
}