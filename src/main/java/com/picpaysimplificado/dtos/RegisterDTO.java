package com.picpaysimplificado.dtos;

import java.math.BigDecimal;
import java.util.List;

import com.picpaysimplificado.domain.role.Role;
import com.picpaysimplificado.domain.user.UserType;

public record RegisterDTO(String firstName, String lastName, String document, BigDecimal balance, String email,
        String password, UserType userType) {

}
