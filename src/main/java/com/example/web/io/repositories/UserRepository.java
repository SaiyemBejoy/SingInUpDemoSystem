package com.example.web.io.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.web.io.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String> {

}
