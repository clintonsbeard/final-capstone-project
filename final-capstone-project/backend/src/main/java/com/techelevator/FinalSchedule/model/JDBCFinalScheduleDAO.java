package com.techelevator.FinalSchedule.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.Schedule.model.Schedule;

@Component
public class JDBCFinalScheduleDAO implements FinalScheduleDAO {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCFinalScheduleDAO (DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	@Override
	public void submitFinalSchedule(FinalSchedule finalSchedule) {
		String insertSql = "INSERT INTO final_schedule (student_name, schedule_id) VALUES " +
				   "(?, ?)";
		jdbcTemplate.update(insertSql, finalSchedule.getStudentName(), finalSchedule.getScheduleId());
	}

	@Override
	public List<FinalSchedule> getFinalScheduleById(int scheduleId) {
		List<FinalSchedule> listOfFinalSchedules = new ArrayList<>();
		String selectSql = "SELECT slot_id, schedule_id, student_name" +
						   "FROM final_schedule WHERE schedule_id = ?";
                
        SqlRowSet results = jdbcTemplate.queryForRowSet(selectSql, scheduleId);
        
        while(results.next()) {
            listOfFinalSchedules.add(mapRowToSqlResults(results));
        }
        return listOfFinalSchedules;
    }

	private FinalSchedule mapRowToSqlResults (SqlRowSet results) {
        FinalSchedule finalSchedule = new FinalSchedule();
        finalSchedule.setSlotId(results.getInt("slot_id"));
        finalSchedule.setScheduleId(results.getInt("schedule_id"));
        finalSchedule.setStudentName(results.getString("student_name"));
        return finalSchedule;
    }
	
}