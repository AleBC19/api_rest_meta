package com.apirestmeta.api_rest_meta.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.apirestmeta.api_rest_meta.models.Users;
import com.apirestmeta.api_rest_meta.repositories.UsersRepository;
import com.apirestmeta.api_rest_meta.services.UsersService;

@RestController
@RequestMapping("api/users")
public class UsersController {

    @Autowired
    private UsersRepository userRepository;
    @Autowired 
    private UsersService userService;

    @GetMapping
    public List<Users> getTask() {
        return userRepository.findAll();
    } 

    @PostMapping(consumes = {"application/json", "application/json;charset=UTF-8"})
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Users> createSesion(@RequestBody Users user) {
        try {
            Users createdUser = userService.createUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        try{
            userService.deleteUser(id);
            return ResponseEntity.noContent().build();
        }catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
