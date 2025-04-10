package com.apirestmeta.api_rest_meta.controllers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirestmeta.api_rest_meta.dtos.TaskDTO;
import com.apirestmeta.api_rest_meta.models.Task;
import com.apirestmeta.api_rest_meta.repositories.TaskRepository;
import com.apirestmeta.api_rest_meta.services.TaskService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public ResponseEntity<Object> createTask(@RequestBody TaskDTO taskDto) {
        try{
            Task savedTask = taskService.createTask(taskDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(new TaskDTO(savedTask));
        }catch(Exception ex){
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("status", HttpStatus.BAD_REQUEST.toString()); 
            errorResponse.put("message", ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    @PutMapping("/update/{idTask}")
    public ResponseEntity<TaskDTO> updateTask(@PathVariable Integer idTask, @RequestBody TaskDTO taskDto) {
        try {
            Task updatedTask = taskService.updateTask(idTask, taskDto);
            return ResponseEntity.status(HttpStatus.OK).body(new TaskDTO(updatedTask));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
