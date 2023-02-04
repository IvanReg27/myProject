package com.vkatit;

import com.vkatit.service.ftp.FtpService;
import org.apache.ftpserver.FtpServer;
import org.apache.ftpserver.ftplet.FtpException;
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
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT, classes = TestContext.class)
@TestInstance(PER_CLASS)
class ImageControllerUnit {
    @LocalServerPort
    int randomPort;
    RestTemplate restTemplate;

    @Autowired
    FtpService ftpService;

    @Autowired
    Environment environment;

    @Autowired
    ApplicationContext applicationContext;

    @Test
    void contextLoads() {
        assertThat(applicationContext, is(notNullValue()));
    }

    @Qualifier("testFtpServer")
    @Autowired
    FtpServer server;

    @BeforeAll
    public void init() throws FtpException {
        restTemplate = new RestTemplate();
        server.start();
    }

    @AfterAll
    public void stop(){
        server.stop();
    }

    @Test
    public void testCountries() throws IOException {
        MultiValueMap<String, Object> body
                = new LinkedMultiValueMap<>();
        body.add("file", new FileSystemResource("C:\\keke.jpeg"));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        HttpEntity<MultiValueMap<String, Object>> requestEntity
                = new HttpEntity<>(body, headers);
        String serverUrl = "http://localhost:" + randomPort + "/images";
        System.out.println(serverUrl);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate
                .postForEntity(serverUrl, requestEntity, String.class);
        System.out.println(response);

        ResponseEntity<byte[]> responseAfter = restTemplate
                .getForEntity(serverUrl + "/"+ "keke.jpeg", byte[].class);

        byte[] expectedBytes = Files.readAllBytes(new File("C:\\keke.jpeg").toPath());
        byte[] actualBytes = responseAfter.getBody();
//        assertEquals(expectedBytes, actualBytes);

        assertThat(expectedBytes, is(equalTo(actualBytes)));


        System.out.println(responseAfter);

//        ftpService.saveFile(new byte[]{0, 1}, "test1");
//        MatcherAssert.assertThat(ftpService.readFile("test1"), is(equalTo(new byte[]{0, 1})));
    }

}
