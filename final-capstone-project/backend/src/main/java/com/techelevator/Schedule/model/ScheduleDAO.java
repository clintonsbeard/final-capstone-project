package com.techelevator.Schedule.model;

import java.util.List;

public interface ScheduleDAO {
	
	public Schedule addDayToSchedule(Schedule schedule);
	
	public List<Schedule> getAllSchedules();
	
	
}