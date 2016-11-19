package com.example;

import org.springframework.data.annotation.Id;

public class Users {

	@Id
	private Long id;
	
	private String username;
	private Integer age;
	public Users() {
		super();
	}
	public Users(Long id, String username, Integer age) {
		super();
		this.id = id;
		this.username = username;
		this.age = age;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", age=" + age + "]";
	}
	
}
