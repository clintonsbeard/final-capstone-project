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

import com.techelevator.Employer.model.Employer;
import com.techelevator.Employer.model.EmployerDAO;
import com.techelevator.Student.model.Student;
import com.techelevator.Student.model.StudentDAO;

@RestController
@CrossOrigin
public class DataInputOutputController {

	@Autowired
	private EmployerDAO employerProfileDAO;
	
	@Autowired
	private StudentDAO studentDAO;
	
	@RequestMapping(path="/employerForm", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Employer submitEmployerForm(@RequestBody Employer employerProfile) {
		 return employerProfileDAO.insertEmployerProfile(employerProfile);
	}
	
	@RequestMapping(path="/studentForm", method=RequestMethod.GET)
	public List<Employer> sendListOfEmployers(){
		return employerProfileDAO.showAllEmployers();
	}
	
	@RequestMapping(path="/studentForm", method=RequestMethod.POST)
	public Student getStudentForms(@RequestBody Student student){
		return studentDAO.insertNewStudentChoices(student);
	}
	
	@RequestMapping(path="/employers/{id}", method=RequestMethod.GET)
	public Employer getEmployerById(@PathVariable int employerId){
		return employerProfileDAO.viewEmployerProfileById(employerId);
	}
	
}