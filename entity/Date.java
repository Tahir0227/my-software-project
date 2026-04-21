package com.entity;

import java.time.LocalDate;
import java.util.Scanner;


public class Date {
	private int day;
	private int month;
	private int year;
	
	public Date() {
		LocalDate today = LocalDate.now();
        this.day = today.getDayOfMonth();
        this.month = today.getMonthValue();
        this.year = today.getYear();
	}
	
	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return String.format("%04d-%02d-%02d", year, month, day);
	}
	
	public void acceptRecord(Scanner sc) {
		System.out.print("Enter date(day month year) : ");
		day = sc.nextInt();
		month = sc.nextInt();
		year = sc.nextInt();
	}
	
}
