package com.entity;

import java.util.Scanner;

public class Customer extends User {
	private String name;
	private String address;
	private String city;
	private String email;
	private String phoneNo;
	
	public Customer() {
		super.setRole("Customer");
	}

	public Customer(int id, String userName, String password, String role, String name, String address,String city, String email, String phoneNo) {
		super(id,userName,password,role);
		this.name = name;
		this.address = address;
		this.city = city;
		this.email = email;
		this.phoneNo = phoneNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
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

	@Override
	public String toString() {
		return String.format(
				"User ID: %d | Role: %s | Name: %s | Address: %s | City: %s | Email: %s | Phone: %s",
				super.getId(), super.getRole(), name, address, city, email, phoneNo);
	}


	public void acceptRecord(Scanner sc) {
		super.acceptRecord(sc);
		sc.nextLine();
		System.out.print("Enter Name : ");
		name = sc.nextLine();
		System.out.print("Enter Address : ");
		address = sc.nextLine();
		System.out.print("Enter City : ");
		city = sc.next();
		System.out.print("Enter E-mail : ");
		email = sc.next();
		System.out.print("Enter Phone number : ");
		phoneNo = sc.next();
	}
}
