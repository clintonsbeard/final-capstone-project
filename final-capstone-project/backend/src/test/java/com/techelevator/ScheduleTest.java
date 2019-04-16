package com.techelevator;

import static org.junit.Assert.assertEquals;

import java.sql.Time;
import java.text.ParseException;
import java.time.LocalTime;
import java.util.List;

import org.junit.*;

import com.techelevator.Schedule.model.Schedule;

public class ScheduleTest {

	private Schedule target;

	@Before
	public void setup() {
		target = new Schedule();
	}

	@Test
	public void incrementTime() throws ParseException {
		// arrange
		int startHour = 13;
		int startMinute = 0;

		int endHour = 18;
		int endMinute = 0;

		int lengthOfSlot = 30;

		LocalTime startTime = LocalTime.of(startHour, startMinute);
		LocalTime endTime = LocalTime.of(endHour, endMinute);

		// act
		/*
		 * increment by 30 minutes
		 */

		String incrementedTime = target.incrementTime(startTime, lengthOfSlot);

		// assert
		assertEquals(new String("13:30"), incrementedTime);
	}

	@Test
	public void getListOfTimesAsString() throws ParseException {
		// arrange
		int startHour = 13;
		int startMinute = 0;

		int endHour = 18;
		int endMinute = 0;

		int lengthOfSlot = 30;

		LocalTime startTime = LocalTime.of(startHour, startMinute);
		LocalTime endTime = LocalTime.of(endHour, endMinute);

		// act
		List<String> slots = target.listOfTimeSlots(startTime, endTime, lengthOfSlot);

		// assert
		assertEquals(11, slots.size());
	}

	@Test
	public void formattedSlotReturnsFormattedTimeSlots() throws ParseException {
		// arrange
		int startHour = 13;
		int startMinute = 0;

		int endHour = 18;
		int endMinute = 0;

		int lengthOfSlot = 30;

		LocalTime startTime = LocalTime.of(startHour, startMinute);
		LocalTime endTime = LocalTime.of(endHour, endMinute);

		// act
		List<String> slots = target.listOfTimeSlots(startTime, endTime, lengthOfSlot);
		List<String> formattedSlots = target.formattedSlots(slots);
		
		//assert
		assertEquals(10, formattedSlots.size());
	}
}
