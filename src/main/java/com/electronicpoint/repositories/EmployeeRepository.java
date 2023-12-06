package com.electronicpoint.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.electronicpoint.domain.employee.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findEmployeeByDocument(String document);

    Optional<Employee> findEmployeeById(Long id);

    UserDetails findByEmail(String email);
}
