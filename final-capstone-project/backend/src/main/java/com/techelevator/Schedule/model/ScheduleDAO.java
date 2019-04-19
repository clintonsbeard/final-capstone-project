package com.techelevator.Schedule.model;

import java.text.ParseException;
import java.util.List;

public interface ScheduleDAO {
	
	public Schedule addDayToSchedule(Schedule schedule);
	
	public List<Schedule> getAllSchedules();
	
	public List<String> getAllTimeSlots(Schedule schedule) throws ParseException;
	
	public Schedule getSchedulesById(int scheduleId);
	
	public List<Schedule> getAllSchedulesAndAttachedEmployers();
	
}