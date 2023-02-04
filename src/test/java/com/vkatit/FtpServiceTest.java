package com.vkatit;

import com.vkatit.service.ftp.FtpService;
import org.apache.ftpserver.FtpServer;
import org.apache.ftpserver.ftplet.FtpException;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT, classes = TestContext.class)
@TestInstance(PER_CLASS)
class FtpServiceTest {
    @LocalServerPort
    int randomPort;
    RestTemplate restTemplate;

    @Autowired
    FtpService ftpService;

    @Autowired
    Environment environment;

    @Autowired
    ApplicationContext applicationContext;

    @Qualifier("testFtpServer")
    @Autowired
    FtpServer server;

    @AfterAll
    public void stop(){
        server.stop();
    }

    @BeforeAll
    public void init() throws FtpException {
        restTemplate = new RestTemplate();
        server.start();
    }

    @Test
    void contextLoads() {
        MatcherAssert.assertThat(applicationContext, is(notNullValue()));
    }

    @Test
    public void testCountries() {
        ftpService.saveFile(new byte[]{0, 1}, "test1");
        MatcherAssert.assertThat(ftpService.readFile("test1"), is(equalTo(new byte[]{0, 1})));
    }

}
