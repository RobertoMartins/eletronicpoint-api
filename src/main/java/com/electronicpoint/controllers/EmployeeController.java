package com.electronicpoint.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
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
import com.electronicpoint.dtos.employee.EmployeeRequestDTO;
import com.electronicpoint.dtos.employee.EmployeeResponseDTO;
import com.electronicpoint.services.EmployeeService;

@RestController()
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    ModelMapper mapper;

    @PostMapping
    public ResponseEntity<Employee> createUser(@RequestBody EmployeeRequestDTO data) {

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());

        Employee newEmployee = employeeService.createEmployee(data, encryptedPassword);
        return new ResponseEntity<Employee>(newEmployee, HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<EmployeeResponseDTO>> getAll() {
        List<EmployeeResponseDTO> employees = this.employeeService.getAllEmployees().stream()
                .map(employee -> mapper.map(employee, EmployeeResponseDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

}
