package com.techelevator;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.*;

import com.techelevator.EmployerProfile.model.EmployerProfile;
import com.techelevator.Scheduler.Appointment;
import com.techelevator.Scheduler.Scheduler;
import com.techelevator.Scheduler.Slot;
import com.techelevator.Student.model.Student;

public class SchedulerTest {

	private Scheduler target;
	private List<Student> allStudents;
	private List<Appointment> allAppointments;
	private List<EmployerProfile> allEmployers;
	private List<Slot> allSlots;
	
	@Before
	public void setup() {
		allStudents = new ArrayList<Student>();
		allAppointments = new ArrayList<Appointment>();
		allEmployers = new ArrayList<EmployerProfile>();
		allSlots = new ArrayList<Slot>();
		target = new Scheduler(allAppointments, allStudents);
	}
	
	@Test
	public void givenOneCompanyAndThreeStudentsItTakesThreeSlotsForSchedule() {
		//arrange
		Student student1 = new Student();
		Student student2 = new Student();
		Student student3 = new Student();
		
		allStudents.add(student1);
		allStudents.add(student2);
		allStudents.add(student3);
			
		EmployerProfile oneEmployer = new EmployerProfile();
		
		allAppointments.add(new Appointment(oneEmployer, new Slot(1)));
		allAppointments.add(new Appointment(oneEmployer, new Slot(2)));
		allAppointments.add(new Appointment(oneEmployer, new Slot(3)));

		//act
		target.setListOfAllStudents(allStudents);
		target.setAllAvailableAppointments(allAppointments);
		Map<Appointment, Student> newSchedule = target.makeSchedule();
		
		//assert
		assertTrue(!newSchedule.isEmpty());
		assertTrue(newSchedule.size() == 3);
	}
	
	@Test
	public void fiveSlotsAndThreeCompaniesMakeFifteenAppointments() {
		//arrange
		for(int i = 1; i <=3; i++) {
			allEmployers.add(new EmployerProfile());
		}
		
		for(int i = 1; i <=5; i++) {
			allSlots.add(new Slot(i));
		}
		
		for(int i = 1; i <=3; i++) {
			allStudents.add(new Student());
		}
		
		//act
		target.setNumberOfEmployers(allEmployers);
		target.setNumberOfSlots(allSlots);
		target.buildAppointmentGrid();
		
		//assert
		assertTrue(target.getAllAvailableAppointments().size() == 15);
		
	}
}
