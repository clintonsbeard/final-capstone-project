package com.techelevator.JoinTable;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCTopFourChoicesDAO implements TopFourChoicesDAO{

	 private JdbcTemplate jdbcTemplate;
	    
	    @Autowired
	    public JDBCTopFourChoicesDAO (DataSource datasource) {
	        jdbcTemplate = new JdbcTemplate(datasource);
	    }

		@Override
		public List<TopFourChoices> getTopFourChoicesOfAllStudents() {
			
			List<TopFourChoices> topFourChoices = new ArrayList<>();
			
			String query = "SELECT * FROM student " 
					+ "JOIN student_employer_top_four ON student_employer_top_four.student_id = student.student_id " 
					+ "JOIN employer ON employer.employer_id = student_employer_top_four.employer_id " 
					+ "JOIN employer_schedule ON employer_schedule.employer_id = employer.employer_id " 
					+ "JOIN schedule ON schedule.schedule_id = employer_schedule.schedule_id";
			
			SqlRowSet results = jdbcTemplate.queryForRowSet(query);
			
			while(results.next()) {
				topFourChoices.add(mapRowToResults(results));
			}
			
			return topFourChoices;
		}
		
        @Override
        public List<TopFourChoices> getTopFourChoicesOfAllStudentsByScheduleId(int scheduleId) {
            
            List<TopFourChoices> topFourChoices = new ArrayList<>();
            
            String query = "SELECT student.student_id, student.first_name, student.last_name, "
                    + "student_employer_top_four.employer_id, employer.company_name, student_employer_top_four.choice_number " 
                    + "FROM student JOIN student_employer_top_four on student_employer_top_four.student_id = student.student_id " 
                    + "JOIN employer ON employer.employer_id = student_employer_top_four.employer_id " 
                    + "JOIN employer_schedule ON employer_schedule.employer_id = employer.employer_id " 
                    + "WHERE employer_schedule.schedule_id = ? ";
            
            SqlRowSet results = jdbcTemplate.queryForRowSet(query, scheduleId);
            
            while(results.next()) {
                topFourChoices.add(mapRowToResultsById(results));
            }
            
            return topFourChoices;
        }
        
        private TopFourChoices mapRowToResultsById(SqlRowSet results) {
            
            TopFourChoices choices = new TopFourChoices();
            
            choices.setStudentId(results.getInt("student_id"));
            choices.setFirstName(results.getString("first_name"));
            choices.setLastName(results.getString("last_name"));
            choices.setEmployerId(results.getInt("employer_id"));
            choices.setCompanyName(results.getString("company_name"));
            choices.setChoiceNumber(results.getInt("choice_number"));

            return choices;
        }
		
		private TopFourChoices mapRowToResults(SqlRowSet results) {
			
			TopFourChoices choices = new TopFourChoices();
			
			choices.setStudentId(results.getInt("student_id"));
			choices.setFirstName(results.getString("first_name"));
			choices.setLastName(results.getString("last_name"));
			choices.setEmployerId(results.getInt("employer_id"));
			choices.setCompanyName(results.getString("company_name"));
			choices.setEmployerPreferredDay(results.getDate("matchmaking_date").toLocalDate());
			choices.setStartTime(results.getTime("start_time"));
			choices.setEndTime(results.getTime("end_time"));

			return choices;
		}
		
}
