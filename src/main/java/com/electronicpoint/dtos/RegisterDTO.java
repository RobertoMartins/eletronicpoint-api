package com.electronicpoint.dtos;

import com.electronicpoint.domain.employee.Position;

public record RegisterDTO(String firstName, String lastName, String document, String email,
                String password, Position position) {

}
