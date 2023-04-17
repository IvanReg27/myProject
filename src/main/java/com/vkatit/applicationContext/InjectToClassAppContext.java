package com.vkatit.applicationContext;

import java.util.List;

public class InjectToClassAppContext {
    @Inject
    private List<String> list;
    @Inject
    private Integer integer;
    @Inject
    private String string;

    public InjectToClassAppContext() {
        integer = 1988;
        list = List.of("1988", "2018", "2022");
        string = null;
    }

    public List<String> getList() {
        return list;
    }
    public Integer getInteger() {
        return integer;
    }
    public String getString() {
        return string;
    }
}