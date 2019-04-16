package com.techelevator.StudentAll.model;

import java.util.List;

public interface StudentAllDAO {

	public StudentAll insertAllChoicesIntoDatabase(StudentAll studentAll);
	public List<StudentAll> getAllRegisteredStudents();
}