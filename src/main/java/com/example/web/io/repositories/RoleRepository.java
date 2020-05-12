package com.example.web.io.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.web.io.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, String> {

}
