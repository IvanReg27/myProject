package com.vkatit;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@TestInstance(PER_CLASS)

public class DemoApplicationTests {

    @LocalServerPort
    private int randomPort;
    private RestTemplate restTemplate;
    @BeforeEach
    public void init() {
        restTemplate = new RestTemplate();
    }
    //не реализовал, см. у других




}