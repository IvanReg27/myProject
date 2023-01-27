package com.vkatit;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vkatit.model.Citizen;
import com.vkatit.model.Country;
import org.mariadb.jdbc.MariaDbDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.List;

@Configuration
public class AppContext {

    @Value("${ip}")
    private String myIp;
    @Value("${username}")
    private String myUsername;
    @Value("${password}")
    private String myPassword;

    @Bean("mariaDataSource")
    public DataSource mariaDataSource() throws SQLException {
        MariaDbDataSource mariaDbDataSource = new MariaDbDataSource();
        mariaDbDataSource.setUrl("jdbc:mariadb://185.106.92.148:3306/hr"); // мой IP сервера
        mariaDbDataSource.setUser("root");
        mariaDbDataSource.setPassword("12oCFWg8SU_2"); //ввести пароль HeidiSQL
        return mariaDbDataSource;
    }

    @Bean
    public NamedParameterJdbcTemplate myNamedParameterJdbcTemplate(DataSource mariaDataSource) throws SQLException {
        return new NamedParameterJdbcTemplate(mariaDataSource);
    }

    @Bean
    public JdbcTemplate myJdbcTemplate(DataSource mariaDataSource) throws SQLException {
        return new JdbcTemplate(mariaDataSource);
    }
}