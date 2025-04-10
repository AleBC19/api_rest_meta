package com.apirestmeta.api_rest_meta.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iduser; 
    private String username; 
    private String password; 


    public Users() {
    }

    public Integer getIduser() {
        return iduser;
    }

    public Users(Integer iduser, String username, String password, List<Task> tasks) {
        this.iduser = iduser;
        this.username = username;
        this.password = password;
        this.tasks = tasks;
    }


    public void setIduser(Integer iduser) {
        this.iduser = iduser;
    }


    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public List<Task> getTasks() {
        return tasks;
    }


    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }


    @OneToMany(mappedBy = "user")
    private List<Task> tasks;
}
