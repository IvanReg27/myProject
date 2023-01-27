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
    private String hireDate;
    private String jobId;
    private Float salary;
    private Integer mangerId;
    private Integer departmentId;
}