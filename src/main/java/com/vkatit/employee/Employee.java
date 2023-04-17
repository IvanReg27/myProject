package com.vkatit.employee;

import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor

public class Employee {

    @JsonField(defaultValue="Ivan")
    private String firstName;
    private String lastName;
    private int age;
    @JsonGetter("employeeFirstName")
    public String getFirstName() {
        return firstName;
    }
    @JsonGetter("employeeLastName")
    public String getLastName() {
        return lastName;
    }
    @JsonGetter("employeeAge")
    public int getAge() {
        return age;
    }
}