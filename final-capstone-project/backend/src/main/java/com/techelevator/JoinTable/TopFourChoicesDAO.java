package com.techelevator.JoinTable;

import java.util.List;

public interface TopFourChoicesDAO {

	public List<TopFourChoices> getTopFourChoicesOfAllStudents();
	
	public List<TopFourChoices> getTopFourChoicesOfAllStudentsByScheduleId(int scheduleId);
	
}
