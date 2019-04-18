package com.techelevator.FinalSchedule.model;

import java.util.List;

public interface FinalScheduleDAO {

//	public FinalSchedule submitFinalSchedule(FinalSchedule[] finalSchedule);
	
	public List<FinalSchedule> getFinalScheduleById(int scheduleId);

	public void submitFinalSchedule(FinalSchedule[] finalSchedule);
	
}