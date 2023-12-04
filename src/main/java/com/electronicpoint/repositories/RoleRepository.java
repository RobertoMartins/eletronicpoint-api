package com.electronicpoint.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.electronicpoint.domain.role.Role;
import com.electronicpoint.enums.RoleName;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(RoleName name);
}
