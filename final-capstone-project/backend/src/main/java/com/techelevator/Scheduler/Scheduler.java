package com.techelevator.Scheduler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.techelevator.EmployerProfile.model.EmployerProfile;
import com.techelevator.Student.model.Student;

public class Scheduler {

	/*
	 * scheduler is collection of Appointments
	 * 
	 * Appointment consists of:
	 * 1. Slot
	 * 2. Company
	 * 
	 * That Appointment is then assigned to a Student
	 * 
	 * The assignment is made per Constraints
	 * 
	 */
	
	private List<Appointment> allAvailableAppointments;
	private List<Student> listOfAllStudents;
	private List<Student> reservedList = new ArrayList<Student>();
	private List<Slot> numberOfSlots = new ArrayList<>();
	private List<EmployerProfile> numberOfEmployers = new ArrayList<>();

	//constructor
	public Scheduler(List<Appointment> allAvailableAppointments, List<Student>listOfAllStudents) {
		this.allAvailableAppointments = new ArrayList<Appointment>();
		this.listOfAllStudents = new ArrayList<Student>();
	}
	
	//getters and setters

	public List<Appointment> getAllAvailableAppointments() {
		return allAvailableAppointments;
	}
	public void setAllAvailableAppointments(List<Appointment> allAvailableAppointments) {
		this.allAvailableAppointments = allAvailableAppointments;
	}

	public List<Student> getListOfAllStudents() {
		return listOfAllStudents;
	}

	public void setListOfAllStudents(List<Student> listOfAllStudents) {
		this.listOfAllStudents = listOfAllStudents;
	}

	public List<Student> getReservedList() {
		return reservedList;
	}

	public void setReservedList(List<Student> reservedList) {
		this.reservedList = reservedList;
	}	

	/*
	 * Build an appointment Grid
	 */
	
	public List<Slot> getNumberOfSlots() {
		return numberOfSlots;
	}

	public void setNumberOfSlots(List<Slot> numberOfSlots) {
		this.numberOfSlots = numberOfSlots;
	}

	public List<EmployerProfile> getNumberOfEmployers() {
		return numberOfEmployers;
	}

	public void setNumberOfEmployers(List<EmployerProfile> numberOfEmployers) {
		this.numberOfEmployers = numberOfEmployers;
	}

	public void buildAppointmentGrid() {
		for(int i = 0; i < numberOfSlots.size(); i++) {
			for(int j = 0; j < numberOfEmployers.size(); j++) {
				allAvailableAppointments.add(new Appointment(numberOfEmployers.get(j), numberOfSlots.get(i)));
			}
		}
	}
	/*
	 * Synchronous assignment
	 */
	
	public Map<Appointment, Student> makeSchedule(){
		Map<Appointment, Student> schedule = new HashMap<>();
		for(int i = 0; i < allAvailableAppointments.size(); i++) {
			schedule.put(allAvailableAppointments.get(i), listOfAllStudents.get(i));
		}
		return schedule;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
