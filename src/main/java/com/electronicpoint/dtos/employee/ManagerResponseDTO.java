package com.electronicpoint.dtos.employee;

import com.electronicpoint.domain.employee.Position;

import lombok.Data;

@Data
public class ManagerResponseDTO {
    private Long id;
    private String firstname;
    private String lastname;
    private Position position;
}
