package com.techelevator.FinalSchedule.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCFinalScheduleDAO implements FinalScheduleDAO {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCFinalScheduleDAO (DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
	}

	@Override
	public FinalSchedule submitFinalSchedule(FinalSchedule finalSchedule) {

//		for (FinalSchedule thisSchedule : finalSchedule) {
		String insertScheduleQuery = "INSERT INTO final_schedule (slot_id, schedule_id, start_time, end_time, " + 
				"student_id, first_name, last_name, company_name, employer_id) " + 
				"VALUES (DEFAULT, ?, ?, ?, ?, (SELECT student.first_name from student " + 
				"WHERE student_id = ?), (SELECT student.last_name from student " + 
				"WHERE student_id = ?), (SELECT company_name FROM employer " + 
				"WHERE employer_id = ?), ?) RETURNING schedule_id";
		
//		SqlRowSet results = jdbcTemplate.queryForRowSet(insertScheduleQuery, 2, thisSchedule.getStartTime(), thisSchedule.getEndTime(),
//							thisSchedule.getStudentId(), thisSchedule.getStudentId(), thisSchedule.getStudentId(),
//							thisSchedule.getEmployerId(), thisSchedule.getEmployerId());
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(insertScheduleQuery, 2, finalSchedule.getStartTime(), finalSchedule.getEndTime(),
				finalSchedule.getStudentId(), finalSchedule.getStudentId(), finalSchedule.getStudentId(),
				finalSchedule.getEmployerId(), finalSchedule.getEmployerId());

		results.next();
		Integer scheduleId = results.getInt(1);
        FinalSchedule finalS = new FinalSchedule();
//		finalSchedule.setScheduleId(results.getInt("schedule_id"));
		return finalSchedule;
		}

	@Override
	public List<FinalSchedule> getFinalScheduleById(int scheduleId) {
		List<FinalSchedule> finalSchedule = new ArrayList<>();
		
		String getSchedule = "SELECT slot_id, schedule_id, start_time, end_time, student_id, first_name, last_name, "
				+ "company_name, employer_id FROM final_schedule WHERE schedule_id = ?;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(getSchedule, scheduleId);
		
		while(results.next()) {
			finalSchedule.add(mapRowToSqlResults(results));
		}
		
		return finalSchedule;
	}

	private FinalSchedule mapRowToSqlResults (SqlRowSet results) {
        FinalSchedule finalSchedule = new FinalSchedule();
        finalSchedule.setSlotId(results.getInt("slot_id"));
        finalSchedule.setScheduleId(results.getInt("schedule_id"));
        finalSchedule.setStartTime(results.getString("start_time"));
        finalSchedule.setEndTime(results.getString("end_time"));
        finalSchedule.setStudentId(results.getInt("student_id"));
        finalSchedule.setFirstName(results.getString("first_name"));
        finalSchedule.setLastName(results.getString("last_name"));
        finalSchedule.setCompanyName(results.getString("company_name"));
        finalSchedule.setEmployerId(results.getInt("employer_id"));
        return finalSchedule;
    }

//	@Override
//	public FinalSchedule submitFinalSchedule(FinalSchedule[] finalSchedule) {
//		// TODO Auto-generated method stub
//		return null;
//	}


}