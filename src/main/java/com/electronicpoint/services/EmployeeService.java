package com.electronicpoint.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electronicpoint.domain.employee.Employee;
import com.electronicpoint.dtos.EmployeeDTO;
import com.electronicpoint.repositories.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public Employee findemployeeById(Long id) throws Exception {
        return this.repository.findEmployeeById(id).orElseThrow(() -> new Exception("Usuário não encontrado"));

    }

    public void saveemployee(Employee employee) {
        this.repository.save(employee);
    }

    public Employee createEmployee(EmployeeDTO data, String encriptedPassword) {


        Employee newEmployee = new Employee(data);
        newEmployee.setPassword(encriptedPassword);
        this.saveemployee(newEmployee);
        return newEmployee;
    }

    public List<Employee> getAllEmployees() {
        return this.repository.findAll();
    }
}
