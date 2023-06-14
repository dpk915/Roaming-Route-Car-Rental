package com.masai.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
@Id 
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int userId;
@Column(name="username",length=10)
private String username;

@Column(name="mailid",nullable=false,unique = true)
private String mailid;
@Column(name="password",length=10 ,nullable=false)
private String passwrod;
@Column(name = "is_deleted", nullable = false)
private int isDeleted;
public User() {
	super();
	// TODO Auto-generated constructor stub
}
public User(String username, String mailid, String passwrod) {
	super();
	this.username = username;
	this.mailid = mailid;
	this.passwrod = passwrod;
}
public int getUserId() {
	return userId;
}

public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getMailid() {
	return mailid;
}
public void setMailid(String mailid) {
	this.mailid = mailid;
}
public String getPasswrod() {
	return passwrod;
}
public void setPasswrod(String passwrod) {
	this.passwrod = passwrod;
}
public int getIsDeleted() {
	return isDeleted;
}
public void setIsDeleted(int isDeleted) {
	this.isDeleted = isDeleted;
}




}
