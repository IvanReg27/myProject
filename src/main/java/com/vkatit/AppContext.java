package com.vkatit;


import org.mariadb.jdbc.MariaDbDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class AppContext {

    @Bean ("mariaDataSource")
public DataSource mariaDataSource() throws SQLException {
    MariaDbDataSource mariaDbDataSource = new MariaDbDataSource();
    mariaDbDataSource.setUrl("jdbc:mariadb://xxx:3306/hr"); //вставить свой Ip адрес и порт
        mariaDbDataSource.setUser("root");
        mariaDbDataSource.setPassword("xxx"); //вставить свой пароль из HeidiSQL
        return mariaDbDataSource;
}

    @Bean
public JdbcTemplate myJdbcTemplate(DataSource mariaDataSource) throws SQLException {
    return new JdbcTemplate(mariaDataSource);
    }
}