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
	
	private List<Appointment> allAvailableAppointments;
	private Queue<Student> listOfAllStudents;
	private Queue<Student> reservedList;
	private List<Slot> numberOfSlots = new ArrayList<>();
	private List<EmployerProfile> numberOfEmployers = new ArrayList<>();

	//constructor
	public Scheduler(List<Appointment> allAvailableAppointments, Queue<Student>listOfAllStudents) {
		this.allAvailableAppointments = new ArrayList<Appointment>();
		this.listOfAllStudents = new ArrayDeque<Student>();
		this.reservedList = new ArrayDeque<Student>();
	}
	
	//getters and setters
	public List<Appointment> getAllAvailableAppointments() {
		return allAvailableAppointments;
	}
	public void setAllAvailableAppointments(List<Appointment> allAvailableAppointments) {
		this.allAvailableAppointments = allAvailableAppointments;
	}

	public Queue<Student> getListOfAllStudents() {
		return listOfAllStudents;
	}

	public void setListOfAllStudents(Queue<Student> listOfAllStudents) {
		this.listOfAllStudents = listOfAllStudents;
	}

	public Queue<Student> getReservedList() {
		return reservedList;
	}

	public void setReservedList(Queue<Student> reservedList) {
		this.reservedList = reservedList;
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
	 * Synchronous assignment
	 */
	
	public Map<Appointment, Student> makeSchedule(){
		Map<Appointment, Student> schedule = new HashMap<>();
		for(int i = 0; i < allAvailableAppointments.size(); i++) {
			schedule.put(allAvailableAppointments.get(i), listOfAllStudents.poll());
		}
		return schedule;
	}
	
	/*
	 * assign each student to an appointment and remove them from list
	 */
	
	public Map<Appointment, Student> oneScenerio() {
		Map<Appointment, Student> schedule = new HashMap<>();
		int countForList = 0;
		int numberOfStudents = listOfAllStudents.size();
		for (int i = 0; i < allAvailableAppointments.size(); i++) {
			Appointment currentAppointment = allAvailableAppointments.get(i);
				Student currentStudent = listOfAllStudents.peek();
				schedule.put(currentAppointment, currentStudent);
				listOfAllStudents.poll();
				reservedList.add(currentStudent);
				countForList++;
			
				currentStudent = reservedList.peek();
				schedule.put(currentAppointment, currentStudent);
				reservedList.poll();
				listOfAllStudents.add(currentStudent);
			
		}
		return schedule;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
