package com.entity;

import java.util.Scanner;

public class Parts {
	private int partNo;
	private String partName;
	private double price;
	private int quantity;
	
	public Parts() {
	}
	
	public Parts(int partNo, String partName, double price, int quantity) {
		this.partNo = partNo;
		this.partName = partName;
		this.price = price;
		this.quantity = quantity;
	}
	public int getPartNo() {
		return partNo;
	}
	
	public void setPartNo(int partNo) {
		this.partNo = partNo;
	}
	
	public String getPartName() {
		return partName;
	}
	
	public void setPartName(String partName) {
		this.partName = partName;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return String.format(
				"Part No: %d | Part Name: %s | Quantity: %d | Price: $%.2f",
				partNo, partName, quantity, price);
	}

	
	public void acceptRecord(Scanner sc) {
		System.out.print("Enter Part No : ");
		partNo = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter PartName : ");
		partName = sc.nextLine();
		System.out.print("Enter Quantity : ");
		quantity = sc.nextInt();
		System.out.print("Enter Price of one part : ");
		price = sc.nextDouble();
	}
	
}
