package com.techelevator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.EmployerProfile.model.EmployerProfile;
import com.techelevator.EmployerProfile.model.EmployerProfileDAO;

@RestController
@CrossOrigin
public class DataInputOutputController {

	@Autowired
	private EmployerProfileDAO employerProfileDAO;
	
	@RequestMapping(path="/employerForm", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public EmployerProfile submitEmployerForm(@RequestBody EmployerProfile employerProfile) {
		 return employerProfileDAO.insertEmployerProfile(employerProfile);
	}
	
	@RequestMapping(path="/studentForm", method=RequestMethod.GET)
	public List<EmployerProfile> sendListOfEmployers(){
		return employerProfileDAO.showAllEmployers();
	}
}