package com.apirestmeta.api_rest_meta.services;

import org.springframework.stereotype.Service;
import com.apirestmeta.api_rest_meta.models.Users;
import com.apirestmeta.api_rest_meta.repositories.UsersRepository;

@Service
public class UsersService {
    private UsersRepository usersRepository; 

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository; 
    }
    public Users createUser(Users user) {
        return usersRepository.save(user); 
    }

    public void deleteUser(Integer id) {
        if (usersRepository.existsById(id)) {
            usersRepository.deleteById(id);
        } else {
            throw new RuntimeException("Sesion not found with id: " + id);
        }
    }
}
