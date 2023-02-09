package com.vkatit.controller;

import com.vkatit.model.Employee;
import com.vkatit.model.Job;
import com.vkatit.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public ResponseEntity<Map<Long, Employee>> getEmployees() {
        return ResponseEntity.status(HttpStatus.OK).body(employeeRepository.getEmployees());
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("employeeId") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(employeeRepository.getEmployees().get(id));
    }

    @GetMapping("/employees/{search}")
    public ResponseEntity<Map<Long, Employee>> searchEmployees(@PathVariable("search") String searchQuery) {
        return ResponseEntity.status(HttpStatus.OK).body(employeeRepository.searchEmployees(searchQuery));
    }

    @GetMapping("/jobs")
    public ResponseEntity<Map<String, Job>> getChartData() {
        return ResponseEntity.status(HttpStatus.OK).body(employeeRepository.getChartData());
    }
}