package com.vkatit;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vkatit.employee.Employee;
import com.vkatit.employee.JsonField;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;

public class JacksonConvertTest {
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void employeeToJson() throws JsonProcessingException, IllegalAccessException {

        Employee employee = new Employee(null, "Makhorin", 35);

        for (Field field: employee.getClass().getDeclaredFields()) {
            JsonField annotation = field.getAnnotation(JsonField.class);
            field.setAccessible(true);
            if (annotation != null && field.get(employee) == null) {
                field.set(employee, annotation.defaultValue());
            }
        }
        String json = objectMapper.writeValueAsString(employee);
        System.out.println(json);
    }
}