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
        if(usersRepository.existsByUsername(user.getUsername())){
            throw new RuntimeException("El nombre de usuario ya existe.");
        }
        return usersRepository.save(user); 
    }

    public Users updateUser(Integer id, Users userUpdate) {
        Users userExist = usersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

                userExist.setUsername(userUpdate.getUsername());
                userExist.setPassword(userUpdate.getPassword());

        return usersRepository.save(userExist);
    }

    public void deleteUser(Integer id) {
        if (usersRepository.existsById(id)) {
            usersRepository.deleteById(id);
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
    }
}
