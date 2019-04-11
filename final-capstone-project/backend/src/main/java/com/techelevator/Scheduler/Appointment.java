package com.techelevator.Scheduler;

import com.techelevator.Employer.model.Employer;

public class Appointment {
	
	private Slot slot;
	private Employer employer;
	
	public Appointment(Employer employer, Slot slot) {
		this.slot = slot;
		this.employer = employer;
	}

	public Slot getSlot() {
		return slot;
	}

	public void setSlot(Slot slot) {
		this.slot = slot;
	}

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}
		
}
