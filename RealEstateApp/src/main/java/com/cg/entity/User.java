package com.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
@Table (name="users")
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class User {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
     private int userId;
     private String password;
     private String role;
@Column(unique=true)
     private String mobile;
@Column(unique=true)
     private String email;
     private String city;
	public User(int userId, String password, String role, String mobile, String email, String city) {
		super();
		this.userId = userId;
		this.password = password;
		this.role = role;
		this.mobile = mobile;
		this.email = email;
		this.city = city;
	}
  public User() {}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}


}
