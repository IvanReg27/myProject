package com.vkatit.repository;

import com.sun.crypto.provider.GCM;
import com.vkatit.model.Employee;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EmployeeRepository {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void createNewEmployee(Employee employee) {
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put("employee_id", employee.getEmployeeId());
        properties.put("first_name", employee.getFirstName());
        properties.put("last_name", employee.getLastName());
        properties.put("email", employee.getEmail());
        properties.put("phone_number", employee.getPhoneNumber());
        properties.put("hire_date", employee.getHireDate());
        properties.put("job_id", employee.getJobId());
        properties.put("salary", employee.getSalary());
        properties.put("commission_pct", employee.getCommissionPct());
        properties.put("manager_id", employee.getManagerId());
        properties.put("department_id", employee.getDepartmentId());

        namedParameterJdbcTemplate.update(
                "INSERT INTO hr.employees(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id) VALUES (:employee_id, :first_name, :last_name, :email, :phone_number, :hire_date, :job_id, :salary, :commission_pct, :manager_id, :department_id)",
                properties
        );
    }

    public Employee getEmployeeById(Long id){
        return jdbcTemplate.queryForObject("SELECT * FROM hr.employees WHERE EMPLOYEE_ID = " + id, new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
                return Employee.builder()
                        .employeeId(rs.getLong("employee_id"))
                        .firstName(rs.getString("first_name"))
                        .lastName(rs.getString("last_name"))
                        .hireDate(rs.getString("hire_date"))
                        .jobId(rs.getString("job_id"))
                        .salary(rs.getFloat("salary"))
                        .managerId(rs.getLong("manager_id"))
                        .departmentId(rs.getLong("department_id"))
                        .build();
            }
        });
    }
    public List<Employee> getAllEmployees() {
        return jdbcTemplate.query("SELECT * FROM hr.employees", new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
                return Employee.builder()
                        .employeeId(rs.getLong("employee_id"))
                        .firstName(rs.getString("first_name"))
                        .lastName(rs.getString("last_name"))
                        .email(rs.getString("email"))
                        .phoneNumber(rs.getString("phone_number"))
                        .hireDate(String.valueOf(rs.getDate("hire_date")))
                        .jobId(rs.getString("job_id"))
                        .salary(rs.getFloat("salary"))
                        .commissionPct(rs.getFloat("commission_pct"))
                        .managerId(rs.getLong("manager_id"))
                        .departmentId(rs.getLong("department_id"))
                        .build();
            }
        });
    }
}