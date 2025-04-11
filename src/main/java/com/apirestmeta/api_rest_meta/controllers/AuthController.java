package com.apirestmeta.api_rest_meta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.apirestmeta.api_rest_meta.models.Users;
import com.apirestmeta.api_rest_meta.repositories.UsersRepository;
import com.apirestmeta.api_rest_meta.services.JwtService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UsersRepository usersRepository; 
    private final JwtService jwtService;

    public AuthController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Users request) {
        if (usersRepository.existsByUsernameAndPassword(request.getUsername(), request.getPassword())) {
            String token = jwtService.generateToken(request.getUsername());
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
    }
}

