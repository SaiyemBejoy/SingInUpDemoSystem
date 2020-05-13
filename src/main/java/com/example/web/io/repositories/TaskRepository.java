package com.example.web.io.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.web.io.entity.TaskEntity;
import com.example.web.io.entity.UserEntity;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {

	List<TaskEntity> findByUser(UserEntity user);
}
