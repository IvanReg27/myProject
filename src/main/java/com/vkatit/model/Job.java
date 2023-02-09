package com.vkatit.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Job {

    private String jobTitle;
    private Float averageSalary;
}