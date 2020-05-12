package com.example.web.io.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.web.io.entity.TaskEntity;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {

}
