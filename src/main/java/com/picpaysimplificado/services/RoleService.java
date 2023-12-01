package com.picpaysimplificado.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.picpaysimplificado.domain.role.Role;
import com.picpaysimplificado.enums.RoleName;
import com.picpaysimplificado.repositories.RoleRepository;

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
