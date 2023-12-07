package com.electronicpoint.dtos.employee;

import java.util.List;

import com.electronicpoint.domain.employee.Position;

import lombok.Data;

@Data
public class EmployeeResponseDTO {

    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private Position position;
    private ManagerResponseDTO manager;
    private List<RoleDTO> roles;

}
