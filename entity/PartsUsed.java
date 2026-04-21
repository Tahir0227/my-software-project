package com.entity;

import java.util.Arrays;
import java.util.Scanner;

public class PartsUsed {
	private int requestID;
	private int[] parts;
	
	public PartsUsed() {
		
	}
	
	public PartsUsed(int requestID, int[] parts) {
		this.requestID = requestID;
		this.parts = parts;
	}

	public int getRequestID() {
		return requestID;
	}

	public void setRequestID(int requestID) {
		this.requestID = requestID;
	}

	public int[] getParts() {
		return parts;
	}

	public void setParts(int[] parts) {
		this.parts = parts;
	}

	@Override
	public String toString() {
		return String.format(
				"Request ID: %d | Parts Used: %s",
				requestID, Arrays.toString(parts));
	}

	
	public void acceptRecord(Scanner sc) {
		System.out.print("Enter request ID : ");
		this.requestID = sc.nextInt();
		
		System.out.print("Enter total no of parts used : ");
		int n = sc.nextInt();
		parts = new int[n];
		for(int i=0; i<n; i++) {
			System.out.print("Enter "+(i+1)+"part ID used : ");
			parts[i] = sc.nextInt();
		}
	}
	
}
