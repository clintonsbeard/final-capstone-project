package com.techelevator.FinalSchedule.model;

import java.util.List;

public interface FinalScheduleDAO {

	public void submitFinalSchedule(FinalSchedule finalSchedule);
	
	public List<FinalSchedule> getFinalScheduleById(int scheduleId);
	
}