package com.techelevator.StudentAll.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.Student.model.Student;

@Component
public class JDBCStudentAllDAO implements StudentAllDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCStudentAllDAO (DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	@Override
	public StudentAll insertAllChoicesIntoDatabase(StudentAll studentAll) {
		String insertStudentInStudenTable = "INSERT INTO student (student_id, first_name, last_name) "
												+ "VALUES (DEFAULT, ?, ?) RETURNING student_id;";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(insertStudentInStudenTable, studentAll.getFirstName(), studentAll.getLastName());
		results.next();
		Integer studentId = results.getInt(1);
		
		for(int i = 0; i < studentAll.getChoices().length; i++) {
			String updateStudentEmployerJoinTable = "INSERT INTO student_all_employer (selection_id, student_id, employer_id, choice_number) VALUES (DEFAULT, ?, ?, ?)";
			jdbcTemplate.update(updateStudentEmployerJoinTable, studentId, studentAll.getChoices()[i], i+1);
		}
		studentAll.setStudentId(studentId);
		return studentAll;
	}
	
	@Override
	public List<Student> getAllRegisteredStudents() {
		List<Student> listOfStudents = new ArrayList<>();
		String selectSql = "SELECT * FROM student_employer_top_four";
		SqlRowSet results = jdbcTemplate.queryForRowSet(selectSql);
		
		while(results.next()) {
			listOfStudents.add(mapRowToSqlResults(results));
		}
		return listOfStudents;
	}
	
}