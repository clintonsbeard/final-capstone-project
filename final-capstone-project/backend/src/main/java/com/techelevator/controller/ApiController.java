package com.techelevator.controller;

import com.techelevator.authentication.AuthProvider;
import com.techelevator.authentication.UnauthorizedException;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * ApiController
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class ApiController {

    @Autowired
    private AuthProvider authProvider;

    @RequestMapping(path="/", method=RequestMethod.GET)
    public String authorizedOnly() throws UnauthorizedException {
    	/*
    	You can lock down which roles are allowed by checking
    	if the current user has a role.
    	In this example, if the user does not have the admin role
    	we send back an unauthorized error.
    	*/
        if(authProvider.userHasRole(new String[] {"admin"})) {
            throw new UnauthorizedException();
        }
        return "Success";
    }
    
    @RequestMapping(path="/list", method=RequestMethod.GET)
    public List<String> list() {
    	List<String> list = new ArrayList<String>();
    	list.add("Item One");
    	list.add("Item Two");
    	list.add("Item Three");
    	return list;
    }
}