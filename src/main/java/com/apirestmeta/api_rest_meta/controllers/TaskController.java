package com.apirestmeta.api_rest_meta.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirestmeta.api_rest_meta.models.Task;
import com.apirestmeta.api_rest_meta.repositories.TaskRepository;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository; 

    @GetMapping
    public List<Task> getTask() {
        return taskRepository.findAll();
    } 
}
