package com.electronicpoint.dtos;

import java.math.BigDecimal;
import java.util.List;

import com.electronicpoint.domain.role.Role;
import com.electronicpoint.domain.user.UserType;

public record RegisterDTO(String firstName, String lastName, String document, BigDecimal balance, String email,
        String password, UserType userType) {

}
