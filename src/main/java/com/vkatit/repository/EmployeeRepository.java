package com.vkatit.repository;

import com.vkatit.model.Employee;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class EmployeeRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Employee getEmployeeById(Long id){
        return jdbcTemplate.queryForObject("SELECT * FROM hr.employees WHERE EMPLOYEE_ID = " + id, new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
                return Employee.builder()
                        .firstName(rs.getString("first_name"))
                        .lastName(rs.getString("last_name"))
                        .mangerId(rs.getInt("manager_id"))
                        .employeeId(rs.getLong("employee_id"))
                        .hireDate(rs.getString("hire_date"))
                        .jobId(rs.getString("job_id"))
                        .build();
            }
        });
    }

}
