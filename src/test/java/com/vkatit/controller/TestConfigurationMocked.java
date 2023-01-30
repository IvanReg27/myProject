package com.vkatit.controller;

import com.vkatit.service.ftp.FtpService;
import com.vkatit.service.ftp.MockFtpService;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class TestConfigurationMocked {

    @Bean
    public FtpService ftpService(){
        return new MockFtpService();
    }

}
