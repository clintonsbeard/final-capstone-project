package com.techelevator.Schedule.model;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Schedule {

	private int scheduleId;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate matchmakingDate;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private LocalTime startTime;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private LocalTime endTime;
	
	private int interviewLength;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private LocalTime breakStartTime;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private LocalTime breakEndTime;
	
	public int getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}
	
	public LocalDate getMatchmakingDate() {
		return matchmakingDate;
	}
	public void setMatchmakingDate(LocalDate matchmakingDate) {
		this.matchmakingDate = matchmakingDate;
	}
	
	public LocalTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
	
	public LocalTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}
	
	public int getInterviewLength() {
		return interviewLength;
	}
	public void setInterviewLength(int interviewLength) {
		this.interviewLength = interviewLength;
	}
	
	public LocalTime getBreakStartTime() {
		return breakStartTime;
	}
	public void setBreakStartTime(LocalTime breakStartTime) {
		this.breakStartTime = breakStartTime;
	}
	
	public LocalTime getBreakEndTime() {
		return breakEndTime;
	}
	public void setBreakEndTime(LocalTime breakEndTime) {
		this.breakEndTime = breakEndTime;
	}
	
}