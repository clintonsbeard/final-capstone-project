package com.techelevator.Schedule.model;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JDBCScheduleDAO implements ScheduleDAO {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCScheduleDAO (DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	@Override
	public Schedule addDayToSchedule(Schedule schedule) {
		String insertSql = "INSERT INTO schedule (schedule_id, matchmaking_date, start_time, end_time, " +
						   "interview_length, break_start_time, break_end_time) VALUES " +
						   "(DEFAULT, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(insertSql, schedule.getMatchmakingDate(), schedule.getStartTime(),
							schedule.getEndTime(), schedule.getInterviewLength(),
							schedule.getBreakStartTime(), schedule.getBreakEndTime());
		return schedule;
	}

}