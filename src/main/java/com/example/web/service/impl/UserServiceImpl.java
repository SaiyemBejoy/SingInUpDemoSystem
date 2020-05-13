package com.example.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.web.io.entity.RoleEntity;
import com.example.web.io.entity.UserEntity;
import com.example.web.io.repositories.UserRepository;
import com.example.web.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void createUser(UserEntity user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		RoleEntity userRole = new RoleEntity("user");
		List<RoleEntity> roles = new ArrayList<>();
		roles.add(userRole);
		user.setRoles(roles);
		userRepository.save(user);
	}

	@Override
	public void createAdmin(UserEntity user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		RoleEntity userRole = new RoleEntity("admin");
		List<RoleEntity> roles = new ArrayList<>();
		roles.add(userRole);
		user.setRoles(roles);
		userRepository.save(user);
	}

	@Override
	public UserEntity findOne(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public boolean isUserPresent(String email) {
		UserEntity user = userRepository.findByEmail(email);
		
		if(user != null) {
			return true;
		}
		
		return false;
	}

	@Override
	public List<UserEntity> findAll() {
		
		return userRepository.findAll();
	}

	@Override
	public List<UserEntity> findByName(String name) {
		return userRepository.findByNameLike("%"+name+"%");
	}
}
