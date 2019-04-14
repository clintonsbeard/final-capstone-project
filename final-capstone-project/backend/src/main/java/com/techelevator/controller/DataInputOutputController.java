package com.techelevator.controller;

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
    private StudentAllDAO studentAllDAO;
    
    @Autowired
    private ScheduleDAO scheduleDAO;
    
    @Autowired
    private AdminChoiceDAO adminChoiceDAO;
    
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
    public void updateStudentEmployerJoinTable(@RequestBody StudentAll studentRanksAllEmployers) {
    int[] choices = studentRanksAllEmployers.getChoices();
    studentAllDAO.insertAllChoicesIntoDatabase(studentRanksAllEmployers);
    }

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
    
//    @RequestMapping(path="/rankAllCompanies", method=RequestMethod.POST)
//    public void updateStudentEmployerJoinTable(@RequestBody StudentAll studentRanksAllEmployers) {
//    int[] choices = studentRanksAllEmployers.getChoices();
//    studentAllDAO.insertAllChoicesIntoDatabase(studentRanksAllEmployers);
//    }
    
}