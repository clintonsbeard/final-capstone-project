package com.techelevator.StudentAll.model;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCStudentAllDAO implements StudentAllDAO {
	
private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCStudentAllDAO (DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
	}

	@Override
	public void insertAllChoicesIntoDatabase(StudentAll studentAll) {
		String insertStudentInStudenTable = "INSERT INTO student (student_id, first_name, last_name) "
												+ "VALUES (DEFAULT, ?, ?) RETURNING student_id;";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(insertStudentInStudenTable, studentAll.getFirstName(), studentAll.getLastName());
		results.next();
		Integer studentId = results.getInt(1);
		
		String insertAllStudentChoicesIntoJoinTable = "INSERT INTO student_employer_2 "
														+ "VALUES (DEFAULT, ?,(UNNEST(ARRAY ?)), "
														+ "nextval('sequence_2')); "
														+ "SELECT setval('sequence_2', 0);";
		jdbcTemplate.update(insertAllStudentChoicesIntoJoinTable, studentId, studentAll.getChoices());
	}

	
}