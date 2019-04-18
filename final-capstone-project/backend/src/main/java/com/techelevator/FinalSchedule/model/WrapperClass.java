package com.techelevator.FinalSchedule.model;

import java.util.List;

public class WrapperClass {

	private int scheduleId;
	private FinalSchedule[] finalSchedule;
	
	public int getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}
	public FinalSchedule[] getFinalSchedule() {
		return finalSchedule;
	}
	public void setFinalSchedule(FinalSchedule[] finalSchedule) {
		this.finalSchedule = finalSchedule;
	}

}
