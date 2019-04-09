package com.techelevator.EmployerProfile.model;

import java.util.List;

public interface EmployerProfileDAO {

	public void insertEmployerProfile(String companyName, String logoFile, String content, int numberOfTeams);
	public EmployerProfile viewEmployerProfile(String companyName);
	public List<EmployerProfile> showAllEmployers();
}
