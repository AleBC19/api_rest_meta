package com.apirestmeta.api_rest_meta.controllers;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apirestmeta.api_rest_meta.dtos.TaskDTO;
import com.apirestmeta.api_rest_meta.models.Task;
import com.apirestmeta.api_rest_meta.repositories.TaskRepository;
import com.apirestmeta.api_rest_meta.services.TaskService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository; 
    @Autowired
    private TaskService taskService; 

    @GetMapping
    public List<Task> getTask() {
        return taskRepository.findAll();
    } 

    @PostMapping(consumes = {"application/json", "application/json;charset=UTF-8"})
    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTO taskDto) {
        try{
            Task savedTask = taskService.createTask(taskDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(new TaskDTO(savedTask));
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); 
        }
    }
}
