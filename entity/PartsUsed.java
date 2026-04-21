package com.entity;

import java.util.Scanner;

public class PartsUsed {
	private int requestId;
	private int partId;
	private int quantity;
	private String notes;
	
	public PartsUsed() {
		
	}
	
	public PartsUsed(int requestId, int partId, int quantity, String notes) {
		this.requestId = requestId;
		this.partId = partId;
		this.quantity = quantity;
		this.notes = notes;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public int getPartId() {
		return partId;
	}

	public void setPartId(int partId) {
		this.partId = partId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return String.format(
				"Request ID: %d | Part ID: %d | Quantity: %d | Notes: %s",
				requestId, partId, quantity, notes);
	}

	public void acceptRecord(Scanner sc) {
		System.out.print("Enter request ID : ");
		this.requestId = sc.nextInt();
		System.out.print("Enter part ID : ");
		this.partId = sc.nextInt();
		System.out.print("Enter quantity : ");
		this.quantity = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter notes : ");
		this.notes = sc.nextLine();
	}
}
