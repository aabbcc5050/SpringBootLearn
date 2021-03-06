package com.example.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/*
 * 教师
 */
@Entity
public class Teacher {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String tecnum;
	private String sex;
	private String birthday;
	private String tchStatus;
	
	/*
	 * 一个老师教多个班级,一个班级有多个老师
	 */
	@ManyToMany
	private Set<Clazz> clazzes;
	
	public Long getId() {
		return id; 
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTecnum() {
		return tecnum;
	}
	public void setTecnum(String tecnum) {
		this.tecnum = tecnum;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getTchStatus() {
		return tchStatus;
	}
	public void setTchStatus(String tchStatus) {
		this.tchStatus = tchStatus;
	}

	
	
}
