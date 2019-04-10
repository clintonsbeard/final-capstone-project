package com.techelevator.Student.model;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCStudentDAO implements StudentDAO{
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCStudentDAO (DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
	}
	

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student getStudentByName(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student insertNewStudentChoices(Student student) {
		String insertSql = "INSERT INTO student (student_id, first_name, last_name, "
				+ "choice_1, choice_2, choice_3, choice_4) "
				+ "VALUES (DEFAULT, ?, ?, ?, ?, ?, ?) RETURNING student_id";
		SqlRowSet results = jdbcTemplate.queryForRowSet(insertSql, student.getFirstName(),
								student.getLastName(), student.getChoice1(),
								student.getChoice2(), student.getChoice3(),
								student.getChoice4());
		results.next();
		student.setStudentId(results.getInt("student_id"));
		return student;
	}

}
