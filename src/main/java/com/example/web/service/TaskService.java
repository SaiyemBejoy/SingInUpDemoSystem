package com.example.web.service;

import java.util.List;

import com.example.web.io.entity.TaskEntity;
import com.example.web.io.entity.UserEntity;

public interface TaskService {
	void addTask(TaskEntity task, UserEntity user);
	List<TaskEntity> findUserTask(UserEntity user);
}
