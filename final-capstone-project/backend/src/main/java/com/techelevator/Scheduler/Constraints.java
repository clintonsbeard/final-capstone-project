package com.techelevator.Scheduler;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.Student.model.JDBCStudentDAO;
import com.techelevator.Student.model.StudentDAO;

public class Constraints {
	
	/*
	 * 1. satisfy all student choices
	 * 2. breaks
	 * 3. employer time restriction
	 * 4. employer technology stock
	 * 5. Duration of appointment
	 * 6. Duration of Schedule
	 * 7. No student has appointments back to back
	 */

	private JdbcTemplate jdbcTemplate;
	private StudentDAO studentDAO;
	
	@Autowired
	public Constraints(DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
		studentDAO = new JDBCStudentDAO(datasource);
	}
	
	
	
}
