package com.techelevator.Employer.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Employer {

	private int employerId;
	private String employerName;
	private String employerSummary;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date daysAttending;
	private int numberOfTeams;
	private String restrictions;
	
	
	public int getEmployerId() {
		return employerId;
	}
	public void setEmployerId(int employerId) {
		this.employerId = employerId;
	}
	
	public String getCompanyName() {
		return employerName;
	}
	public void setCompanyName(String companyName) {
		this.employerName = companyName;
	}
	
	public String getCompanySummary() {
		return employerSummary;
	}
	public void setCompanySummary(String companySummary) {
		this.employerSummary = companySummary;
	}
	
	public Date getDaysAttending() {
		return daysAttending;
	}
	public void setDaysAttending(Date daysAttending) {
		this.daysAttending = daysAttending;
	}
	
	public int getNumberOfTeams() {
		return numberOfTeams;
	}
	public void setNumberOfTeams(int numberOfTeams) {
		this.numberOfTeams = numberOfTeams;
	}
	
	public String getRestrictions() {
		return restrictions;
	}
	public void setRestrictions(String restrictions) {
		this.restrictions = restrictions;
	}

}