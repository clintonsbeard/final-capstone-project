package com.techelevator.StudentAll.model;

public class StudentAll {

	private int studentId;
	private String firstName;
	private String lastName;
	private int[] choices;
	
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
	
	public int[] getChoices() {
		return choices;
	}
	public void setChoices(int[] choices) {
		this.choices = choices;
	}
	
}