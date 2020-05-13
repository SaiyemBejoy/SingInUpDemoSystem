package com.example.web.io.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.web.io.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String> {
	UserEntity findByEmail(String email);

	List<UserEntity> findByNameLike(String name);
}
