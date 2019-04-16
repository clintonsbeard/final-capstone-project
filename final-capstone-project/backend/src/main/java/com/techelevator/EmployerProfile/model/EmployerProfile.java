package com.techelevator.EmployerProfile.model;

import com.fasterxml.jackson.annotation.JsonFormat;

public class EmployerProfile {

    private int employerId;
    private String companyName;
    private String companySummary;
    private String email;
    private String website;
    private String positionsSummary;
    private String pathPreference;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private boolean[] daysAttending;
    private int numberOfTeams;
    private String restrictions;
    
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
	
	public String getCompanySummary() {
		return companySummary;
	}
	public void setCompanySummary(String companySummary) {
		this.companySummary = companySummary;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	
	public String getPositionsSummary() {
		return positionsSummary;
	}
	public void setPositionsSummary(String positionsSummary) {
		this.positionsSummary = positionsSummary;
	}
	
	public String getPathPreference() {
		return pathPreference;
	}
	public void setPathPreference(String pathPreference) {
		this.pathPreference = pathPreference;
	}
	
	public boolean[] getDaysAttending() {
		return daysAttending;
	}
	public void setDaysAttending(boolean[] daysAttending) {
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