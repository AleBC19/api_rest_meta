package com.apirestmeta.api_rest_meta.dtos;

import com.apirestmeta.api_rest_meta.models.Task;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class TaskDTO {
    private Integer idTask; 
    private String description; 
    private String state; 
   // private Integer userId;


    public TaskDTO(Task task) {
        this.idTask = task.getIdtask().intValue();
        this.description = task.getDescription();
        this.state = task.getState();
       // this.userId = task.getUser();
    } 
}
