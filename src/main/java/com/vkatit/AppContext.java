package com.vkatit;


import org.mariadb.jdbc.MariaDbDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class AppContext {

    //@Value("${ip}")
    //private String myIp;
    //@Value("${username}")
    //private String myUsername;
    //@Value("${password}")
    //private String myPassword;

    @Bean ("mariaDataSource")
public DataSource mariaDataSource() throws SQLException {
    MariaDbDataSource mariaDbDataSource = new MariaDbDataSource();
    mariaDbDataSource.setUrl("jdbc:mariadb://185.106.92.148:3306/hr"); //вставить свой Ip адрес и порт
        mariaDbDataSource.setUser("root");
        mariaDbDataSource.setPassword("12oCFWg8SU_2"); //вставить свой пароль из HeidiSQL
        return mariaDbDataSource;
}

    @Bean
public JdbcTemplate myJdbcTemplate(DataSource mariaDataSource) throws SQLException {
    return new JdbcTemplate(mariaDataSource);
    }
}