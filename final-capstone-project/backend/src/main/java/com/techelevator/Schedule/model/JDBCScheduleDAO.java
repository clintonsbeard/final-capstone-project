package com.techelevator.Schedule.model;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.EmployerProfile.model.EmployerProfile;

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
	
	@Override
	public List<Schedule> getAllSchedulesAndAttachedEmployers() {
		List<Schedule> listOfSchedules = new ArrayList<>();
    	String selectSql = "SELECT s.schedule_id, s.matchmaking_date, s.start_time, s.end_time, " +
    					   "s.interview_length, s.break_start_time, s.break_end_time, e.employer_id, " +
    					   "e.company_name, e.company_summary, e.email, e.website, e.positions_summary, " +
    					   "e.path_preference, e.number_of_teams, e.restrictions" +
    					   "FROM schedule s JOIN employer_schedule es ON es.schedule_id = s.schedule_id " +
    					   "JOIN employer e ON e.employer_id = es.employer_id";
    	SqlRowSet results = jdbcTemplate.queryForRowSet(selectSql);
    	
    	while(results.next()) {
            listOfSchedules.add(mapRowToSqlExtraResults(results));
        }
		return listOfSchedules;
    }
	
	private Schedule mapRowToSqlExtraResults (SqlRowSet results) {
        Schedule schedule = new Schedule();
        schedule.setScheduleId(results.getInt("schedule_id"));
        schedule.setMatchmakingDate(results.getDate("matchmaking_date").toLocalDate());
        schedule.setStartTime(results.getTime("start_time").toLocalTime());
        schedule.setEndTime(results.getTime("end_time").toLocalTime());
        schedule.setInterviewLength(results.getInt("interview_length"));
        schedule.setBreakStartTime(results.getTime("break_start_time").toLocalTime());
        schedule.setBreakEndTime(results.getTime("break_end_time").toLocalTime());
        List<EmployerProfile> listOfEmployers = new ArrayList<>();
        while(results.next()) {
        	EmployerProfile empProf = new EmployerProfile();
            empProf.setEmployerId(results.getInt("employer_id"));
            empProf.setCompanyName(results.getString("company_name"));
            empProf.setCompanySummary(results.getString("company_summary"));
            empProf.setEmail(results.getString("email"));
            empProf.setWebsite(results.getString("website"));
            empProf.setPositionsSummary(results.getString("positions_summary"));
            empProf.setPathPreference(results.getString("path_preference"));
            empProf.setNumberOfTeams(results.getInt("number_of_teams"));
            empProf.setRestrictions(results.getString("restrictions"));
            listOfEmployers.add(empProf);
        }
        schedule.setEmployers(listOfEmployers);
        return schedule;
    }
}