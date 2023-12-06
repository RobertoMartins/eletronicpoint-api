package com.electronicpoint.dtos.auth;

import com.electronicpoint.domain.employee.Position;

public record RegisterDTO(String firstName, String lastName, String document, String email,
                String password, Position position) {

}
