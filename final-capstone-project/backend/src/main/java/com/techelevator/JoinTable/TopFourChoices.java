package com.techelevator.JoinTable;

import java.sql.Time;
import java.time.LocalDate;

public class TopFourChoices {
	
	private int studentId;
	private String firstName;
	private String lastName;
	private int employerId;
	private String companyName;
	private LocalDate employerPreferredDay;
	private Time startTime;
	private Time endTime;
	private int choiceNumber;
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getEmployerId() {
		return employerId;
	}
	public void setEmployerId(int employerId) {
		this.employerId = employerId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public LocalDate getEmployerPreferredDay() {
		return employerPreferredDay;
	}
	public void setEmployerPreferredDay(LocalDate employerPreferredDay) {
		this.employerPreferredDay = employerPreferredDay;
	}
	public Time getStartTime() {
		return startTime;
	}
	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}
	public Time getEndTime() {
		return endTime;
	}
	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}
	public int getChoiceNumber() {
		return choiceNumber;
	}
	public void setChoiceNumber(int choiceNumber) {
		this.choiceNumber = choiceNumber;
	}
	
}
