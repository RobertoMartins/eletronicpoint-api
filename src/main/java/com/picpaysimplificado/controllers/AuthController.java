package com.picpaysimplificado.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.picpaysimplificado.domain.role.Role;
import com.picpaysimplificado.domain.user.User;
import com.picpaysimplificado.dtos.AuthDTO;
import com.picpaysimplificado.dtos.AuthResponseDTO;
import com.picpaysimplificado.dtos.RegisterDTO;
import com.picpaysimplificado.infra.security.TokenService;
import com.picpaysimplificado.repositories.UserRepository;
import com.picpaysimplificado.services.RoleService;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticatedAuthorizationManager;

    @Autowired
    private UserRepository repository;

    @Autowired
    TokenService tokenService;

    @Autowired
    RoleService roleService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody AuthDTO data) {

        UsernamePasswordAuthenticationToken usernamePassword = new UsernamePasswordAuthenticationToken(data.login(),
                data.password());
        Authentication auth = this.authenticatedAuthorizationManager.authenticate(usernamePassword);

        String token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new AuthResponseDTO(token));

    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterDTO data) {

        if (repository.findByEmail(data.email()) != null)
            return ResponseEntity.badRequest().build();
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());

        User newUser = new User(data);
        newUser.setPassword(encryptedPassword);

        List<Role> rolesUser = new ArrayList<Role>();
        rolesUser.add(roleService.findByName("USER"));

        newUser.setRoles(rolesUser);

        this.repository.save(newUser);

        return ResponseEntity.ok(newUser);

    }

}
