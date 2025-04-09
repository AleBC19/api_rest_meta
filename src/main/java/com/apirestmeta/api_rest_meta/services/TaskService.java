package com.apirestmeta.api_rest_meta.services;

import org.springframework.stereotype.Service;

import com.apirestmeta.api_rest_meta.models.Task;
import com.apirestmeta.api_rest_meta.repositories.TaskRepository;

@Service
public class TaskService {
    private TaskRepository taskRepository; 

    public Task createTask(Task task) {
        return taskRepository.save(task); 
    }
}
