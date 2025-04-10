package com.apirestmeta.api_rest_meta.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirestmeta.api_rest_meta.dtos.TaskDTO;
import com.apirestmeta.api_rest_meta.models.Task;
import com.apirestmeta.api_rest_meta.models.Users;
import com.apirestmeta.api_rest_meta.repositories.TaskRepository;
import com.apirestmeta.api_rest_meta.repositories.UsersRepository;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository; 
    @Autowired
    private UsersRepository userRepository; 

    public Task createTask(TaskDTO taskDto) {
        Users user = userRepository.findById(taskDto.getUserId())
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    
            boolean exists = taskRepository.existsByDescriptionAndUserIduser(taskDto.getDescription(), user.getIduser());
            if (exists) {
                throw new RuntimeException("El usuario ya tiene una tarea con esa descripción.");
            }
        Task task = taskDto.toEntity(user);
        return taskRepository.save(task);
    }

    public Task updateTask(Integer idTask, TaskDTO taskDto) {
        Task existingTask = taskRepository.findById(idTask)
            .orElseThrow(() -> new RuntimeException("Tarea no encontrada con id: " + idTask));
    
        existingTask.setDescription(taskDto.getDescription());
        existingTask.setState(taskDto.getState());
    
        if (taskDto.getUserId() != null) {
            Users user = userRepository.findById(taskDto.getUserId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + taskDto.getUserId()));
            existingTask.setUser(user);
        }
        return taskRepository.save(existingTask);
    }
    
}
