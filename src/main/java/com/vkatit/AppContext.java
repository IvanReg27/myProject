package com.vkatit;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppContext {


    @Bean()
    public List<String> getUsers() {
        List<String> users = new ArrayList<>();
        users.add("Peter");
        users.add("James");
        return users;
    }

}
