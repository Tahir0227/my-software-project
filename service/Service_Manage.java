package com.service;

import java.time.LocalDate;
import java.util.Scanner;

import com.entity.Date;

public class Service_Manage {
	private Service_Request sr = new Service_Request();
	private int technicianID;
	private Date completeDate;
	
	public Service_Manage() {
		
	}

	public Service_Manage(Service_Request sr, int technicianID, Date completeDate) {
		this.sr = sr;
		this.technicianID = technicianID;
		this.completeDate = completeDate;
	}

	public Service_Request getSr() {
		return sr;
	}

	public void setSr(Service_Request sr) {
		this.sr = sr;
	}

	public int getTechnicianID() {
		return technicianID;
	}

	public void setTechnicianID(int technicianID) {
		this.technicianID = technicianID;
	}

	public String getCompleteDate() {
		return completeDate.toString();
	}

	public void setCompleteDate(java.sql.Date sqlDate) {
        LocalDate localDate = sqlDate.toLocalDate();
        this.completeDate = new com.entity.Date(localDate.getDayOfMonth(), localDate.getMonthValue(), localDate.getYear());
	}

	@Override
	public String toString() {
		return String.format(
				"Request ID: %d | Customer ID: %d | Technician ID: %d | Issue: %s | Status: %s | Request Date: %s | Completion Date: %s",
				sr.getRequestId(), sr.getCustomerID(), technicianID, sr.getIssueDescription(), sr.getStatus(), sr.getRequestDate(), completeDate);
	}

	
	public void acceptRecord(Scanner sc,Service_Request sr) {
		this.sr = sr;
		this.sr.setStatus("In Progress");
		System.out.print("Enter technician ID : ");
		technicianID = sc.nextInt();
		
		System.out.print("Enter completed date(day month year) : ");
		this.completeDate = new Date(sc.nextInt(),sc.nextInt(),sc.nextInt());
	}
	
}
