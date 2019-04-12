package com.techelevator.Scheduler;

import java.sql.Time;

public class Slot {
	
	private int day;
	private Time startTime;
	private Time endTime;
	private int slotNumber;
	
	public Slot(int slotNumber) {
		this.slotNumber = slotNumber;
	}
	
	public int getSlotNumber() {
		return slotNumber;
	}
	public void setSlotNumber(int slotNumber) {
		this.slotNumber = slotNumber;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public Time getStartTime() {
		return startTime;
	}
	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}
	public Time getEndTime() {
		return endTime;
	}
	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

}
