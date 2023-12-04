package com.electronicpoint.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electronicpoint.domain.user.User;
import com.electronicpoint.dtos.UserDTO;
import com.electronicpoint.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User findUserById(Long id) throws Exception {
        return this.repository.findUserById(id).orElseThrow(() -> new Exception("Usuário não encontrado"));

    }

    public void saveUser(User user) {
        this.repository.save(user);
    }

    public User createUser(UserDTO data, String encriptedPassword) {


        User newUser = new User(data);
        newUser.setPassword(encriptedPassword);
        this.saveUser(newUser);
        return newUser;
    }

    public List<User> getAllUsers() {
        return this.repository.findAll();
    }
}
