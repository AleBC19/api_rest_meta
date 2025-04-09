package com.apirestmeta.api_rest_meta.dtos;

import com.apirestmeta.api_rest_meta.models.Users;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class UsersDTO {
    private Integer IdUser; 
    private String Username; 
    private String Password;


    public UsersDTO(Users user) {
        IdUser = user.getIduser().intValue();
        Username = user.getUsername();
        Password = user.getPassword();
    } 
}
