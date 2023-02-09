package com.vkatit.repository;

import com.vkatit.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Map<Long, Employee> getEmployees() {
        return jdbcTemplate.query("SELECT * FROM hr.employees\n" +
                "JOIN hr.jobs ON hr.employees.job_id = hr.jobs.job_id\n" +
                "JOIN hr.departments ON hr.employees.department_id = hr.departments.department_id\n" +
                "JOIN hr.locations ON hr.departments.location_id = hr.locations.location_id\n" +
                "JOIN hr.countries ON hr.locations.country_id = hr.countries.country_id\n" +
                "JOIN hr.regions ON hr.countries.region_id = hr.regions.region_id", new ResultSetExtractor<Map>() {
            @Override
            public Map extractData(ResultSet rs) throws SQLException {
                HashMap<Long, Employee> map = new HashMap<>();
                while(rs.next()){
                    map.put(rs.getLong("employee_id"), Employee.builder()
                            .employeeId(rs.getLong("employee_id"))
                            .firstName(rs.getString("first_name"))
                            .lastName(rs.getString("last_name"))
                            .email(rs.getString("email"))
                            .hireDate(rs.getDate("hire_date"))
                            .salary(rs.getFloat("salary"))
                            .jobTitle(rs.getString("job_title"))
                            .departmentName(rs.getString("department_name"))
                            .streetAddress(rs.getString("street_address"))
                            .postalCode(rs.getString("postal_code"))
                            .city(rs.getString("city"))
                            .countryName(rs.getString("country_name"))
                            .regionName(rs.getString("region_name"))
                            .build());
                }
                return map;
            }
        });
    }

    public Map<Long, Employee> searchEmployees(String searchQuery) {
        return jdbcTemplate.query("SELECT * FROM hr.employees\n" +
                "JOIN hr.jobs ON hr.employees.job_id = hr.jobs.job_id\n" +
                "JOIN hr.departments ON hr.employees.department_id = hr.departments.department_id\n" +
                "JOIN hr.locations ON hr.departments.location_id = hr.locations.location_id\n" +
                "JOIN hr.countries ON hr.locations.country_id = hr.countries.country_id\n" +
                "JOIN hr.regions ON hr.countries.region_id = hr.regions.region_id\n" +
                "WHERE first_name LIKE '%" + searchQuery + "%'\n" +
                "OR last_name LIKE '%" + searchQuery + "%'\n" +
                "OR street_address LIKE '%" + searchQuery + "%'", new ResultSetExtractor<Map>() {
            @Override
            public Map extractData(ResultSet rs) throws SQLException {
                HashMap<Long, Employee> map = new HashMap<>();
                while(rs.next()){
                    map.put(rs.getLong("employee_id"), Employee.builder()
                            .employeeId(rs.getLong("employee_id"))
                            .firstName(rs.getString("first_name"))
                            .lastName(rs.getString("last_name"))
                            .email(rs.getString("email"))
                            .hireDate(rs.getDate("hire_date"))
                            .salary(rs.getFloat("salary"))
                            .jobTitle(rs.getString("job_title"))
                            .departmentName(rs.getString("department_name"))
                            .streetAddress(rs.getString("street_address"))
                            .postalCode(rs.getString("postal_code"))
                            .city(rs.getString("city"))
                            .countryName(rs.getString("country_name"))
                            .regionName(rs.getString("region_name"))
                            .build());
                }
                return map;
            }
        });
    }

    public Map<String, BatchProperties.Job> getChartData() {
        return jdbcTemplate.query("SELECT hr.jobs.job_id, hr.jobs.job_title, AVG(hr.employees.salary)\n" +
                "FROM hr.jobs\n" +
                "JOIN hr.employees ON hr.jobs.job_id = hr.employees.job_id\n" +
                "GROUP BY hr.jobs.job_title", new ResultSetExtractor<Map>() {
            @Override
            public Map extractData(ResultSet rs) throws SQLException {
                HashMap<String, BatchProperties.Job> map = new HashMap<>();
                while(rs.next()){
                    map.put(rs.getString("job_id"), BatchProperties.Job.builder()
                            .jobTitle(rs.getString("job_title"))
                            .averageSalary(rs.getFloat("avg(hr.employees.salary)"))
                            .build());
                }
                return map;
            }
        });
    }

}