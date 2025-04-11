package com.apirestmeta.api_rest_meta.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public ResponseEntity<Object> createUser(@RequestBody Users user) {
        try {
            Users createdUser = userService.createUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
        } catch (Exception ex) {
            ex.printStackTrace();
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> putMethodName(@PathVariable Integer id, @RequestBody Users userUpdate) {
        try{
            Users sesionMod = userService.updateUser(id, userUpdate);
            return ResponseEntity.ok(sesionMod);
        }catch(Exception ex) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", ex.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Integer id) {
        try{
            userService.deleteUser(id);
            return ResponseEntity.noContent().build();
        }catch (Exception ex) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("status", HttpStatus.NOT_FOUND.toString()); 
            errorResponse.put("message", ex.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }
}
