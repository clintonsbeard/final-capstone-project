package com.techelevator.Student.model;

import java.util.List;

public interface StudentDAO {

	public List<Student> getAllStudents();
	public Student getStudentByName(String firstName, String lastName);
	public void insertStudentInfo(String firstName, String lastName, int choice1, int choice2, int choice3, int choice4);
}
