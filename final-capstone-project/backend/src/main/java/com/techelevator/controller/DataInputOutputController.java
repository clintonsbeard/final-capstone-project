package com.techelevator.controller;

import java.text.ParseException;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.AdminFormChoice.AdminChoice;
import com.techelevator.AdminFormChoice.AdminChoiceDAO;
import com.techelevator.EmployerProfile.model.EmployerProfile;
import com.techelevator.EmployerProfile.model.EmployerProfileDAO;
import com.techelevator.FinalSchedule.model.FinalSchedule;
import com.techelevator.FinalSchedule.model.FinalScheduleDAO;
import com.techelevator.FinalSchedule.model.WrapperClass;
import com.techelevator.JoinTable.StudentRanksAllEmployers;
import com.techelevator.JoinTable.StudentRanksAllEmployersDAO;
import com.techelevator.JoinTable.TopFourChoices;
import com.techelevator.JoinTable.TopFourChoicesDAO;
import com.techelevator.Schedule.model.Schedule;
import com.techelevator.Schedule.model.ScheduleDAO;
import com.techelevator.Student.model.Student;
import com.techelevator.Student.model.StudentDAO;
import com.techelevator.StudentAll.model.StudentAll;
import com.techelevator.StudentAll.model.StudentAllDAO;

@RestController
@CrossOrigin
public class DataInputOutputController {

    @Autowired
    private EmployerProfileDAO employerProfileDAO;
    
    @Autowired
    private StudentDAO studentDAO;
    
    @Autowired
    private ScheduleDAO scheduleDAO;
    
    @Autowired
    private AdminChoiceDAO adminChoiceDAO;
    
    @Autowired
    private StudentAllDAO studentAllDAO;
    
    @Autowired
    private TopFourChoicesDAO topFourChoicesDAO;
    
    @Autowired
    private StudentRanksAllEmployersDAO studentRanksAllEmployersDAO;
    
    @Autowired
    private FinalScheduleDAO finalScheduleDAO;
    
    @RequestMapping(path="/employerForm", method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public EmployerProfile submitEmployerForm(@RequestBody EmployerProfile employerProfile) {
         return employerProfileDAO.insertEmployerProfile(employerProfile);
    }
    
    @RequestMapping(path="/studentForm", method=RequestMethod.GET)
    public List<EmployerProfile> sendListOfEmployers(){
        return employerProfileDAO.showAllEmployers();
    }
    
    @RequestMapping(path="/studentForm", method=RequestMethod.POST)
    public Student postStudentChoices(@RequestBody Student student){
        return studentDAO.insertNewStudentChoices(student);
    }
        
    @RequestMapping(path="/employers/{id}", method=RequestMethod.GET)
    public EmployerProfile getEmployerById(@PathVariable int id){
        return employerProfileDAO.viewEmployerProfile(id);
    }
    
    @RequestMapping(path="/employers/update", method=RequestMethod.PUT)
    public EmployerProfile updateEmployerProfile(@RequestBody EmployerProfile employer){
        return employerProfileDAO.updateEmployerProfile(employer);
    }
    
    @RequestMapping(path="/schedules", method=RequestMethod.GET)
    public List<Schedule> getAllSchedules(){
        return scheduleDAO.getAllSchedules();
    }
    
    @RequestMapping(path="/schedule/add", method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Schedule addDayToSchedule(@RequestBody Schedule schedule){
        return scheduleDAO.addDayToSchedule(schedule);
    }
    
    @RequestMapping(path="/toggleRankingChoice", method=RequestMethod.PUT)
    public void changeRankingSystem(@RequestBody AdminChoice rankingChoice) {
    	adminChoiceDAO.setAdminFormChoice(rankingChoice);
    }
    
    @RequestMapping(path="/checkRankingChoice", method=RequestMethod.GET)
    public AdminChoice checkRankingSystemChoice() {
    	return adminChoiceDAO.getAdminFormChoice();
    }
    
    @RequestMapping(path="/rankAllCompanies", method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public StudentAll updateStudentEmployerJoinTable(@RequestBody StudentAll studentRanksAllEmployers) {
    	return studentAllDAO.insertAllChoicesIntoDatabase(studentRanksAllEmployers);
    }
    
    @RequestMapping(path="/students", method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.CREATED)
    public List<StudentAll> getListOfAllStudents(){
    	return studentAllDAO.getAllRegisteredStudents();
    }
    
    @RequestMapping(path="/getEverything", method=RequestMethod.GET)
    public List<StudentRanksAllEmployers> getEverything() {
    	return studentRanksAllEmployersDAO.getStudentRankingAllEmployersInfo();
    }
    
    @RequestMapping(path="/timeslots/{id}", method=RequestMethod.GET)
    public List<String> getTimeSlots(@PathVariable int id) throws ParseException {
    	return scheduleDAO.getAllTimeSlots(scheduleDAO.getSchedulesById(id));
    }
    
    @RequestMapping(path="/employersBySchedule/{id}", method=RequestMethod.GET)
    public List<EmployerProfile> getEmployersInSchedule(@PathVariable int id) throws ParseException {
    	return employerProfileDAO.showEmployersByScheduleId(id);
    }

    @RequestMapping(path="/studentsBySchedule/{id}", method=RequestMethod.GET)
    public List<TopFourChoices> getStudentsBySchedule(@PathVariable int id) {
    	return topFourChoicesDAO.getTopFourChoicesOfAllStudentsByScheduleId(id);
    }
    
    @RequestMapping(path="/schedule/{id}", method=RequestMethod.GET)
    public Schedule getScheduleById(@PathVariable int id) {
    	return scheduleDAO.getSchedulesById(id);
    }
    
    @RequestMapping(path="/submitFinalSchedule", method=RequestMethod.POST)
    public void insertFinalSchedule(@RequestBody FinalSchedule[] finalSchedule) {
    	finalScheduleDAO.submitFinalSchedule(finalSchedule);
    }
    
    @RequestMapping(path="/getFinalSchedule/{id}", method=RequestMethod.GET)
    public List<FinalSchedule> getFinalScheduleById(@PathVariable int id) {
    	return finalScheduleDAO.getFinalScheduleById(id);
    }
    @RequestMapping(path="/getSchedulesAndEmployers", method=RequestMethod.GET)
    public List<Schedule> getSchedulesAndEmployers() {
    	return scheduleDAO.getAllSchedulesAndAttachedEmployers();
    }

}