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
	
	// Additional methods for GUI compatibility
	public String getFirstName() {
		return name != null ? name.split(" ")[0] : "";
	}
	
	public void setFirstName(String firstName) {
		if (name == null) {
			name = firstName;
		} else {
			String[] parts = name.split(" ", 2);
			name = firstName + (parts.length > 1 ? " " + parts[1] : "");
		}
	}
	
	public String getLastName() {
		if (name != null && name.contains(" ")) {
			String[] parts = name.split(" ", 2);
			return parts.length > 1 ? parts[1] : "";
		}
		return "";
	}
	
	public void setLastName(String lastName) {
		if (name == null) {
			name = lastName;
		} else {
			String[] parts = name.split(" ", 2);
			name = (parts.length > 0 ? parts[0] : "") + " " + lastName;
		}
	}
	
	public String getPhone() {
		return phoneNo;
	}
	
	public void setPhone(String phone) {
		this.phoneNo = phone;
	}
	
	public String getSpecialization() {
		return skill;
	}
	
	public void setSpecialization(String specialization) {
		this.skill = specialization;
	}
	
	public int getExperience() {
		return 5; // Default experience, can be enhanced later
	}
	
	public void setExperience(int experience) {
		// Store experience in a field if needed
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
