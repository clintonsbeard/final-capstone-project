package com.techelevator.EmployerProfile.model;

import java.time.LocalDate;
import java.util.List;

public interface EmployerProfileDAO {

	public EmployerProfile viewEmployerProfile(String companyName);
	public List<EmployerProfile> showAllEmployers();
	public EmployerProfile insertEmployerProfile(EmployerProfile employerProfile);
}
