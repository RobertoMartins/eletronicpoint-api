package com.electronicpoint.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.electronicpoint.domain.role.Role;
import com.electronicpoint.services.RoleService;

@RestController()
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    RoleService service;

    @GetMapping
    public ResponseEntity<List<Role>> getAllRoles() {
        List<Role> roles = service.getAllRoles();
        return new ResponseEntity<List<Role>>(roles, HttpStatus.OK);
    }

}
