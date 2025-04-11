package com.apirestmeta.api_rest_meta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apirestmeta.api_rest_meta.models.Users;

public interface UsersRepository extends JpaRepository<Users, Integer>{
    boolean existsByUsername(String username);
    boolean existsByUsernameAndPassword(String username, String password);
}
