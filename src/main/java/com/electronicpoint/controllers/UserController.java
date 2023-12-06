package com.electronicpoint.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.electronicpoint.domain.employee.Employee;
import com.electronicpoint.dtos.EmployeeDTO;
import com.electronicpoint.services.EmployeeService;

@RestController()
@RequestMapping("/users")
public class UserController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> createUser(@RequestBody EmployeeDTO data) {

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());

        Employee newEmployee = employeeService.createEmployee(data, encryptedPassword);
        return new ResponseEntity<Employee>(newEmployee, HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAll() {
        List<Employee> employees = this.employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

}
