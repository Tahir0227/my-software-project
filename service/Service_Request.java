package com.service;

import java.time.LocalDate;
import java.util.Scanner;

import com.entity.Date;

public class Service_Request {
	private int requestId;
	private int customerID;
	private String issueDescription;
	private String status;
	private Date requestDate;
	
	public Service_Request() {
	}

	public Service_Request(int requestId, int customerID, String issueDescription, String status, Date requestDate) {
		this.requestId = requestId;
		this.customerID = customerID;
		this.issueDescription = issueDescription;
		this.status = status;
		this.requestDate = requestDate;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getIssueDescription() {
		return issueDescription;
	}

	public void setIssueDescription(String issueDescription) {
		this.issueDescription = issueDescription;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRequestDate() {
		return requestDate.toString();
	}

	public void setRequestDate(java.sql.Date sqlDate) {
        LocalDate localDate = sqlDate.toLocalDate();
        this.requestDate = new com.entity.Date(localDate.getDayOfMonth(), localDate.getMonthValue(), localDate.getYear());
    }

	@Override
	public String toString() {
		return String.format(
				"Request ID: %d | Customer ID: %d | Issue: %s | Status: %s | Date: %s",
				requestId, customerID, issueDescription, status, requestDate);
	}

	
	public void acceptRecord(Scanner sc) {
		System.out.print("Enter customer ID : ");
		customerID = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter issue : ");
		issueDescription = sc.nextLine();
		status = "Pending";
		requestDate = new Date();
		
	}
	
}
