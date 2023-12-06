package com.electronicpoint.dtos;

import java.util.List;

import com.electronicpoint.domain.employee.Position;
import com.electronicpoint.domain.role.Role;

public record EmployeeDTO(String firstName, String lastName, String document, String email,
        String password, Position position, List<Role> roles) {

}
