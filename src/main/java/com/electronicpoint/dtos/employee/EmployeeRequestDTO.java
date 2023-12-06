package com.electronicpoint.dtos.employee;

import java.util.List;

import com.electronicpoint.domain.employee.Position;
import com.electronicpoint.domain.role.Role;

public record EmployeeRequestDTO(String firstName, String lastName, String document, String email,
        String password, Position position, List<Role> roles) {

}
