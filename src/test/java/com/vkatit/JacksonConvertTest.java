package com.vkatit;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vkatit.employee.Employee;
import org.junit.jupiter.api.Test;

public class JacksonConvertTest {
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void employeeToJson() throws JsonProcessingException {
        Employee employee = new Employee("Makhorin", "Ivan", 35);
        String json = objectMapper.writeValueAsString(employee);
        System.out.println(json);
    }
}