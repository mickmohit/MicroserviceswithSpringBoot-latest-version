package com.mohit.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})// use it so that  "hibernateLazyInitializer": {} doesn't comes in your Json output
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private long deptId;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getDeptId() {
		return deptId;
	}
	public void setDeptId(long deptId) {
		this.deptId = deptId;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", deptId=" + deptId + "]";
	}
	public User(long id, String name, long deptId) {
		super();
		this.id = id;
		this.name = name;
		this.deptId = deptId;
	}
	
	public User() {}
}
