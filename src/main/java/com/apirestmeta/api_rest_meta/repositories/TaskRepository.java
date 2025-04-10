package com.apirestmeta.api_rest_meta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apirestmeta.api_rest_meta.models.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    boolean existsByDescriptionAndUserIduser(String description, Integer iduser);
}
