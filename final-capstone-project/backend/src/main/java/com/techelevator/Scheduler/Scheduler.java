package com.techelevator.Scheduler;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

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
	
	private Queue<Appointment> allAvailableAppointments;
	private List<Student> listOfAllStudents;
	private List<Slot> numberOfSlots = new ArrayList<>();
	private List<EmployerProfile> numberOfEmployers = new ArrayList<>();

	//constructor
	public Scheduler(Queue<Appointment> allAvailableAppointments, List<Student>listOfAllStudents) {
		this.allAvailableAppointments = new ArrayDeque<Appointment>();
		this.listOfAllStudents = new ArrayList<Student>();
	}
	
	//getters and setters
	public Queue<Appointment> getAllAvailableAppointments() {
		return allAvailableAppointments;
	}
	public void setAllAvailableAppointments(Queue<Appointment> allAvailableAppointments) {
		this.allAvailableAppointments = allAvailableAppointments;
	}

	public List<Student> getListOfAllStudents() {
		return listOfAllStudents;
	}

	public void setListOfAllStudents(List<Student> listOfAllStudents) {
		this.listOfAllStudents = listOfAllStudents;
	}
	
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

	/*
	 * Build an appointment Grid
	 */
	
	public void buildAppointmentGrid() {
		for(int i = 0; i < numberOfSlots.size(); i++) {
			for(int j = 0; j < numberOfEmployers.size(); j++) {
				allAvailableAppointments.add(new Appointment(numberOfEmployers.get(j), numberOfSlots.get(i)));
			}
		}
	}
	
	/*
	 * assign each student to an appointment and remove them from list
	 */
	
	public Map<Appointment, Student> assignStudentsToAppointments() {
		Map<Appointment, Student> schedule = new HashMap<>();
		int studentListIndex = 0;
		int numberOfStudents = listOfAllStudents.size();
		
		while(!allAvailableAppointments.isEmpty()) {
			schedule.put(allAvailableAppointments.poll(), listOfAllStudents.get(studentListIndex));
			studentListIndex++;
			if(studentListIndex == numberOfStudents) {
				studentListIndex = 0;
			}
		}
		
		return schedule;
	}
	
}
