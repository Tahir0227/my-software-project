package com.entity;

import java.util.Scanner;

public class Technician extends User {
	private String name;
	private String phoneNo;
	private String skill;
	private boolean isAvailable;
	
	public Technician() {
		super.setRole("Technician");
	}
	
	public Technician(int id, String userName, String password, String role, String name, String phoneNo, String skill) {
		super(id,userName,password,role);
		this.name = name;
		this.phoneNo = phoneNo;
		this.skill = skill;
		this.isAvailable = true;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}
	
	
	public boolean getisAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	@Override
	public String toString() {
		return String.format(
				"User ID: %d | Name: %s | Phone: %s | Skill: %s | Available: %b",
				super.getId(), name, phoneNo, skill, isAvailable);
	}


	public void acceptRecord(Scanner sc) {
		super.acceptRecord(sc);
		sc.nextLine();
		System.out.print("Enter Name : ");
		name = sc.nextLine();
		System.out.print("Enter Phone No : ");
		phoneNo = sc.next();
		sc.nextLine();
		System.out.print("Enter Skill : ");
		skill = sc.nextLine();
		isAvailable = true;
	}
}
