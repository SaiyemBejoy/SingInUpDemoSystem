package com.example.web.service;

import java.util.List;

import com.example.web.io.entity.UserEntity;

public interface UserService {
	void createUser(UserEntity user);
	void createAdmin(UserEntity user);
	UserEntity findOne(String email);
	boolean isUserPresent(String email);
	List<UserEntity> findAll();
	List<UserEntity> findByName(String name);
}
