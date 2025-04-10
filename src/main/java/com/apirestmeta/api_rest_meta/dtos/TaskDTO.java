package com.apirestmeta.api_rest_meta.dtos;

import com.apirestmeta.api_rest_meta.models.Task;
import com.apirestmeta.api_rest_meta.models.Users;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class TaskDTO {
    private Integer idTask; 
    private String description; 
    private String state; 
    private Integer userId;


    public TaskDTO(Task task) {
        this.idTask = task.getIdtask().intValue();
        this.description = task.getDescription();
        this.state = task.getState();
        this.userId = task.getUser().getIduser();
    } 

    public Task toEntity(Users user) {
        Task task = new Task();
        task.setIdtask(this.idTask);
        task.setDescription(this.description);
        task.setState(this.state);
        task.setUser(user);
        return task;
    }
}
