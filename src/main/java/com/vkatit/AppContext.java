package com.vkatit;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vkatit.model.Citizen;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppContext {

    @Value("classpath:citizen1000.json")
    Resource resource;

    @Value("${name}")
    String johnString;

    @Bean("myCitizensList")
    public List<Citizen> citizens() {
        try (InputStream inputStream = resource.getInputStream()) {
            String json = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);

            final ObjectMapper objectMapper = new ObjectMapper();
            List<Citizen> citizens = objectMapper.readValue(json, new TypeReference<List<Citizen>>(){});
            return citizens;
        } catch (IOException e) {
            return null;
        }
    }

}
