package com.entity;

import java.util.Scanner;

public class User {
	private int Id;
	private String userName;
	private String password;
	private String role;
	
	public User(){
		
	}
	
	public User(int id, String userName, String password, String role) {
		this.Id = id;
		this.userName = userName;
		this.password = password;
		this.role = role;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	@Override
	public String toString() {
		return String.format(
				"User ID: %d | Username: %s | Role: %s",
				Id, userName, role);
	}

	
	public void acceptRecord(Scanner sc) {
		System.out.print("Enter Username : ");
		userName = sc.next();
		System.out.print("Enter Password : ");
		password = sc.next();
	}
	
}
