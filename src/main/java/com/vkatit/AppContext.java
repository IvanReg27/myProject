package com.vkatit;

import org.mariadb.jdbc.MariaDbDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;

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
        mariaDbDataSource.setUrl("jdbc:mariadb://xxx/hr"); // мой IP сервера
        mariaDbDataSource.setUser("root");
        mariaDbDataSource.setPassword("xxx2"); //ввести пароль HeidiSQL
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