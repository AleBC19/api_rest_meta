package com.apirestmeta.api_rest_meta.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirestmeta.api_rest_meta.models.Users;
import com.apirestmeta.api_rest_meta.repositories.UsersRepository;

@RestController
@RequestMapping("api/users")
public class UsersController {

    @Autowired
    private UsersRepository userRepository; 

    @GetMapping
    public List<Users> getTask() {
        return userRepository.findAll();
    } 
}
