package com.vkatit.model;


import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Builder
@Data
public class Employee {

    private Long employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private Date hireDate;
    private Float salary;
    private String jobTitle;
    private String departmentName;
    private String streetAddress;
    private String postalCode;
    private String city;
    private String countryName;
    private String regionName;
}