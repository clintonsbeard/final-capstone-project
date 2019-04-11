package com.techelevator.Scheduler;

import com.techelevator.EmployerProfile.model.EmployerProfile;

public class Appointment {
	
	private Slot slot;
	private EmployerProfile employer;
	
	public Appointment(EmployerProfile employer, Slot slot) {
		this.slot = slot;
		this.employer = employer;
	}

	public Slot getSlot() {
		return slot;
	}

	public void setSlot(Slot slot) {
		this.slot = slot;
	}

	public EmployerProfile getEmployer() {
		return employer;
	}

	public void setEmployer(EmployerProfile employer) {
		this.employer = employer;
	}
		
}
