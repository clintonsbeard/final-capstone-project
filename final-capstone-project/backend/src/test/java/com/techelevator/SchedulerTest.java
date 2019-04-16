package com.techelevator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.junit.*;

import com.techelevator.EmployerProfile.model.EmployerProfile;
import com.techelevator.Scheduler.Appointment;
import com.techelevator.Scheduler.Scheduler;
import com.techelevator.Scheduler.Slot;
import com.techelevator.Student.model.Student;

public class SchedulerTest {

	private Scheduler target;
	private List<Student> allStudents;
	private Queue<Appointment> allAppointments;
	private List<EmployerProfile> allEmployers;
	private List<Slot> allSlots;
	
	@Before
	public void setup() {
		allStudents = new ArrayList<Student>();
		allAppointments = new ArrayDeque<Appointment>();
		allEmployers = new ArrayList<EmployerProfile>();
		allSlots = new ArrayList<Slot>();
		target = new Scheduler(allAppointments, allStudents);
	}
	
	/*
	 * Build Apointment Grid
	 */
	@Test
	public void fiveSlotsAndThreeCompaniesMakeFifteenAppointments() {
		//arrange
		for(int i = 1; i <=3; i++) {
			allEmployers.add(new EmployerProfile(i));
		}
		
		for(int i = 1; i <=5; i++) {
			allSlots.add(new Slot(i));
		}
		
		//act
		target.setNumberOfEmployers(allEmployers);
		target.setNumberOfSlots(allSlots);
		target.buildAppointmentGrid();
		
		//assert
		assertTrue(target.getAllAvailableAppointments().size() == 15);
		
	}
	
	/*
	 * Scenario for One Employer, Three Students and One Day of matchmaking
	 */
	
	@Test
	public void givenOneCompanyAndThreeStudentsItTakesThreeSlotsForSchedule() {
		//arrange
		Student student1 = new Student(1);
		Student student2 = new Student(2);
		Student student3 = new Student(3);
		
		allStudents.add(student1);
		allStudents.add(student2);
		allStudents.add(student3);
			
		EmployerProfile oneEmployer = new EmployerProfile(1);
		
		allEmployers.add(oneEmployer);
		
		Slot slot1 = new Slot(1);
		Slot slot2 = new Slot(2);
		Slot slot3 = new Slot(3);

		allSlots.add(slot1);
		allSlots.add(slot2);
		allSlots.add(slot3);
		
		//act
		target.setListOfAllStudents(allStudents);
		target.setNumberOfSlots(allSlots);
		target.setNumberOfEmployers(allEmployers);
		target.buildAppointmentGrid();
		Map<Appointment, Student> newSchedule = target.assignStudentsToAppointments();
		
		//assert
		assertTrue(!newSchedule.isEmpty());
		assertTrue(newSchedule.size() == 3);
	}
	
	/*
	 * when number of appointments is same as number of students
	 */
	@Test
	public void scenarioForThreeEmployersFiveSlotsFifteenAppointments() {
		//arrange
		for(int i = 1; i <=3; i++) {
			allEmployers.add(new EmployerProfile(i));
		}
		
		for(int i = 1; i <=3; i++) {
			allSlots.add(new Slot(i));
		}
		
		for(int i = 1; i <=3; i++) {
			allStudents.add(new Student(i));
		}
		
		//act
		target.setNumberOfEmployers(allEmployers);
		target.setNumberOfSlots(allSlots);
		target.buildAppointmentGrid();
		target.setListOfAllStudents(allStudents);
		
		//assert
		/*
		 * each employer met each student
		 * loop through appointments with a given employer
		 * and all studens in there are unique
		 */
		assertEquals(9, target.getAllAvailableAppointments().size());
		
		Map<Appointment, Student> newSchedule = target.assignStudentsToAppointments();
		
		//assert
		
	}
}
