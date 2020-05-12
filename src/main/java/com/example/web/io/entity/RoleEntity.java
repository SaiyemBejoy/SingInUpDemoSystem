package com.example.web.io.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity(name = "role")
public class RoleEntity {

	@Id
	private String name;

	@ManyToMany(mappedBy = "roles")
	private List<UserEntity> users;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}

	public RoleEntity(String name, List<UserEntity> users) {
		this.name = name;
		this.users = users;
	}

	public RoleEntity() {
	}

	public RoleEntity(String name) {
		this.name = name;
	}

}
