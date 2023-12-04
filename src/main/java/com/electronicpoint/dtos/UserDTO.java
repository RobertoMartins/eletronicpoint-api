package com.electronicpoint.dtos;

import java.util.List;

import com.electronicpoint.domain.role.Role;
import com.electronicpoint.domain.user.UserType;

public record UserDTO(String firstName, String lastName, String document, String email,
        String password, UserType userType, List<Role> roles) {

}
