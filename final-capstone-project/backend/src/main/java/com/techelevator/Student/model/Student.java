package com.techelevator.Student.model;

import com.techelevator.Employer.model.Employer;
import com.techelevator.Scheduler.Slot;

public class Student {

	private int studentId;
	private String firstName;
	private String lastName;
	private String choice1;
	private String choice2;
	private String choice3;
	private String choice4;
	private Employer assignedEmployer;
	private Slot assignedSlot;
	
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
	public String getChoice1() {
		return choice1;
	}
	public void setChoice1(String choice1) {
		this.choice1 = choice1;
	}
	public String getChoice2() {
		return choice2;
	}
	public void setChoice2(String choice2) {
		this.choice2 = choice2;
	}
	public String getChoice3() {
		return choice3;
	}
	public void setChoice3(String choice3) {
		this.choice3 = choice3;
	}
	public String getChoice4() {
		return choice4;
	}
	public void setChoice4(String choice4) {
		this.choice4 = choice4;
	}
	public Employer getAssignedEmployer() {
		return assignedEmployer;
	}
	public void setAssignedEmployer(Employer assignedEmployer) {
		this.assignedEmployer = assignedEmployer;
	}
	public Slot getAssignedSlot() {
		return assignedSlot;
	}
	public void setAssignedSlot(Slot assignedSlot) {
		this.assignedSlot = assignedSlot;
	}

}
