package com.electronicpoint.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electronicpoint.domain.role.Role;
import com.electronicpoint.enums.RoleName;
import com.electronicpoint.repositories.RoleRepository;

@Service
public class RoleService {
    @Autowired
    RoleRepository repository;

    public List<Role> getAllRoles() {
        return repository.findAll();
    }

    public Role findByName(String name) {
        return repository.findByRoleName(RoleName.valueOf(name)).get();
    }
}
