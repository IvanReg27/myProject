package com.vkatit;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vkatit.model.Citizen;
import com.vkatit.model.Country;
import org.mariadb.jdbc.MariaDbDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.List;

@Configuration
public class AppContext {

    @Value("classpath:citizen10.json")
    Resource citizenResource;

    @Value("classpath:countries.json")
    Resource countriesResource;

    @Bean
    public List<Citizen> citizens() {
        try (InputStream inputStream = citizenResource.getInputStream()) {
            String json = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            final ObjectMapper objectMapper = new ObjectMapper();
            List<Citizen> citizens = objectMapper.readValue(json, new TypeReference<List<Citizen>>() {
            });
            return citizens;
        } catch (IOException e) {
            return null;
        }
    }

    @Bean
    public List<Country> countries() {
        try (InputStream inputStream = countriesResource.getInputStream()) {
            String json = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            final ObjectMapper objectMapper = new ObjectMapper();
            List<Country> countries = objectMapper.readValue(json, new TypeReference<List<Country>>() {
            });
            return countries;
        } catch (IOException e) {
            return null;
        }
    }

    @Bean("mariaDataSource")
    public DataSource mariaDataSource() throws SQLException {
        MariaDbDataSource mariaDbDataSource = new MariaDbDataSource();
        mariaDbDataSource.setUrl("jdbc:mariadb://IP:3306/hr");
        mariaDbDataSource.setUser("root");
        mariaDbDataSource.setPassword("");
        return mariaDbDataSource;
    }

    @Bean
    public JdbcTemplate myJdbcTemplate(DataSource mariaDataSource) throws SQLException {
        return new JdbcTemplate(mariaDataSource);
    }


}
