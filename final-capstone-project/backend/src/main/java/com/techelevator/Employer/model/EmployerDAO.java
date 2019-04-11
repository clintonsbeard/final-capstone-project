package com.techelevator.Employer.model;

import java.util.List;

public interface EmployerDAO {

	public Employer viewEmployerProfileById(int employerId);
		
	public Employer insertEmployerProfile(Employer employerProfile);

	public List<Employer> showAllEmployers();
	
}