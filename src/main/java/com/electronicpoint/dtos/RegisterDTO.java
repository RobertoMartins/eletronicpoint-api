package com.electronicpoint.dtos;

import com.electronicpoint.domain.user.UserType;

public record RegisterDTO(String firstName, String lastName, String document, String email,
        String password, UserType userType) {

}
