package com.techelevator.Schedule.model;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCScheduleDAO implements ScheduleDAO {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCScheduleDAO (DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	@Override
	public void addDayToSchedule(Schedule schedule) {
		String insertSql = "INSERT INTO schedule (matchmaking_date, start_time, end_time, " +
						   "interview_length, break_start_time, break_end_time) VALUES " +
						   "(?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(insertSql, schedule.getMatchmakingDate(), schedule.getStartTime(),
							schedule.getEndTime(), schedule.getInterviewLength(),
							schedule.getBreakStartTime(), schedule.getBreakEndTime());
	}

	@Override
    public Schedule getSchedulesById(int scheduleId) {
        String selectSql = "SELECT schedule_id, matchmaking_date, start_time, end_time, " +
        		"interview_length, break_start_time, break_end_time from schedule " 
                + "WHERE schedule_id = ?";
                
        SqlRowSet results = jdbcTemplate.queryForRowSet(selectSql, scheduleId);
        
        results.next();
        return mapRowToSqlResults(results);
    }
	
	@Override
	public List<String> getAllTimeSlots(Schedule schedule) throws ParseException {
		return schedule.formattedSlots(schedule.listOfTimeSlots(schedule.getStartTime(), schedule.getEndTime(), schedule.getInterviewLength()));
	}

	private Schedule mapRowToSqlResults (SqlRowSet results) {
        Schedule schedule = new Schedule();
        schedule.setScheduleId(results.getInt("schedule_id"));
        schedule.setMatchmakingDate(results.getDate("matchmaking_date").toLocalDate());
        schedule.setStartTime(results.getTime("start_time").toLocalTime());
        schedule.setEndTime(results.getTime("end_time").toLocalTime());
        schedule.setInterviewLength(results.getInt("interview_length"));
        schedule.setBreakStartTime(results.getTime("break_start_time").toLocalTime());
        schedule.setBreakEndTime(results.getTime("break_end_time").toLocalTime());
        return schedule;
    }

	@Override
    public List<Schedule> getAllSchedules() {
        List<Schedule> listOfSchedules = new ArrayList<>();
        String selectSql = "SELECT schedule_id, matchmaking_date, start_time, end_time, interview_length, " +
                           "break_start_time, break_end_time FROM schedule"; 
        
        SqlRowSet results = jdbcTemplate.queryForRowSet(selectSql);
        
        while(results.next()) {
            listOfSchedules.add(mapRowToSqlResults(results));
        }
        return listOfSchedules;
    }
	
}