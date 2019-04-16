package com.techelevator.JoinTable;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCStudentRanksAllEmployersDAO implements StudentRanksAllEmployersDAO{

	private JdbcTemplate jdbcTemplate;
	
	public JDBCStudentRanksAllEmployersDAO(DataSource datasource) {
        jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	@Override
	public List<StudentRanksAllEmployers> getStudentRankingAllEmployersInfo() {
		
		List<StudentRanksAllEmployers> allRankings = new ArrayList<>();
		
		String query = "SELECT * FROM student " + 
				"JOIN student_employer_rank_all ON student_employer_rank_all.student_id = student.student_id " + 
				"JOIN employer ON employer.employer_id = student_employer_rank_all.employer_id " + 
				"JOIN employer_schedule ON employer_schedule.employer_id = employer.employer_id " + 
				"JOIN schedule ON schedule.schedule_id = employer_schedule.schedule_id";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(query);
		
		while(results.next()) {
			allRankings.add(mapRowToResults(results));
		}
		
		return allRankings;
	}
	
	private StudentRanksAllEmployers mapRowToResults(SqlRowSet results) {
		
		StudentRanksAllEmployers thisRanking = new StudentRanksAllEmployers();
		
		thisRanking.setStudentId(results.getInt("employer_id"));
		thisRanking.setFirstName(results.getString("first_name"));
		thisRanking.setLastName(results.getString("last_name"));
		thisRanking.setEmployerId(results.getInt("employer_id"));
		thisRanking.setCompanyName(results.getString("company_name"));
		thisRanking.setChoiceNumber(results.getInt("choice_number"));
		thisRanking.setEmployerPreferredDay(results.getDate("matchmaking_date").toLocalDate());
		thisRanking.setStartTime(results.getTime("start_time"));
		thisRanking.setEndTime(results.getTime("end_time"));

		return thisRanking;
	}

}
