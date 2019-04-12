package com.techelevator.EmployerProfile.model;

import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class EmployerProfile {

    private int employerId;
    private String companyName;
    private String companySummary;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate daysAttending;
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
    
    public LocalDate getDaysAttending() {
        return daysAttending;
    }
    public void setDaysAttending(LocalDate daysAttending) {
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