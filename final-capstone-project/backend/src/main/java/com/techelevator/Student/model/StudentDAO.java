package com.techelevator.Student.model;

import java.util.List;

public interface StudentDAO {

	public List<Student> getAllStudents();
	public Student getStudentByName(String firstName, String lastName);
	public Student insertNewStudentChoices(Student student);
}
