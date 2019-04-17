package com.techelevator.EmployerProfile.model;

import java.util.List;

public interface EmployerProfileDAO {

    public EmployerProfile viewEmployerProfile(int employerId);
    
    public List<EmployerProfile> showAllEmployers();
    
    public List<EmployerProfile> showEmployersByScheduleId(int scheduleId);
    
    public EmployerProfile insertEmployerProfile(EmployerProfile employerProfile);
    
    public EmployerProfile updateEmployerProfile(EmployerProfile employerProfile);
        
}