package com.example.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.web.io.entity.TaskEntity;
import com.example.web.io.entity.UserEntity;
import com.example.web.io.repositories.TaskRepository;
import com.example.web.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	TaskRepository taskRepository;

	@Override
	public void addTask(TaskEntity task, UserEntity user) {
		task.setUser(user);
		taskRepository.save(task);
	}

	@Override
	public List<TaskEntity> findUserTask(UserEntity user) {
		return taskRepository.findByUser(user);
	}
}
