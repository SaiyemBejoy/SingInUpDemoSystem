package com.example.web.io.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity(name = "user")
public class UserEntity {

	@Id
	@Email
	@Column(unique = true, nullable = false, length = 100)
	private String email;

	@Column(nullable = false, length = 50)
	private String name;

	@Size(min = 4)
	@Column(nullable = false, length = 10)
	private String password;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<TaskEntity> tasks;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_roles", joinColumns = {
			@JoinColumn(name = "user_email", referencedColumnName = "email") }, inverseJoinColumns = {
					@JoinColumn(name = "role_name", referencedColumnName = "name") })
	private List<RoleEntity> roles;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<TaskEntity> getTask() {
		return tasks;
	}

	public void setTask(List<TaskEntity> task) {
		this.tasks = task;
	}

	public List<RoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	}

	public UserEntity(String email, String name, String password) {
		this.email = email;
		this.name = name;
		this.password = password;
	}

	public UserEntity() {

	}
}
