package com.vkatit;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.vkatit.model.Citizen;
import com.vkatit.model.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class AppContext {

    @Value("classpath:citizen1000.json")
    Resource resource;

    @Bean
    public List<Citizen> citizens() {
        try (InputStream inputStream = resource.getInputStream()) {
            String json = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            final ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(json, new TypeReference<List<Citizen>>(){});
        } catch (IOException e) {
            return null;
        }
    }

    @Bean("citizensData")
    public Map<Long,Citizen> citizenMap(List<Citizen> citizens) {
        Map<Long,Citizen> allCitizens = new HashMap<>();
        for(Citizen citizen: citizens){
            allCitizens.put(citizen.getId(), citizen);
        }
        return allCitizens;
    }

}
