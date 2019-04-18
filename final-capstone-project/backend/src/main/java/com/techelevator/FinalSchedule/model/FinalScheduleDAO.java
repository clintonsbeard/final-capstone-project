package com.techelevator.FinalSchedule.model;

import java.util.List;

public interface FinalScheduleDAO {

//	public FinalSchedule submitFinalSchedule(FinalSchedule[] finalSchedule);
	
	public List<FinalSchedule> getFinalScheduleById(int scheduleId);

	FinalSchedule submitFinalSchedule(FinalSchedule finalSchedule);
	
}