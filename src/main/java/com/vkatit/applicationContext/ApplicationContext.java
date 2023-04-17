package com.vkatit.applicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApplicationContext {
    private final Map<Class<?>, Object> applicationContext = new HashMap<>();
    public ApplicationContext() {

        List<String> list = new ArrayList<>();
        list.add("I like Java");
        list.add("I really like Java");

        applicationContext.put(List.class, list);
        applicationContext.put(Integer.class, 35);
        applicationContext.put(String.class, "My name is Ivan");
    }
    public <T> T getInjectToClassAppContext(Class<T> clazz) {
        return clazz.cast(applicationContext.get(clazz));
    }
}