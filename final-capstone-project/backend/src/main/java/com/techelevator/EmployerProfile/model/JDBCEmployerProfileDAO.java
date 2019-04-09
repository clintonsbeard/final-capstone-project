package com.techelevator.EmployerProfile.model;

import java.time.LocalDate;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCEmployerProfileDAO implements EmployerProfileDAO{

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCEmployerProfileDAO (DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	@Override
	public EmployerProfile viewEmployerProfile(String companyName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployerProfile> showAllEmployers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployerProfile insertEmployerProfile(EmployerProfile employerProfile) {
		String insertSql = "INSERT INTO employer (employer_id, company_name, company_summary, "
				+ "days_attending, number_of_teams, restrictions) "
				+ "VALUES (DEFAULT, ?, ?, ?, ?, ?) RETURNING employer_id";		
		SqlRowSet results = jdbcTemplate.queryForRowSet(insertSql,
				employerProfile.getCompanyName(), 
				employerProfile.getCompanySummary(), 
				employerProfile.getDaysAttending(), 
				employerProfile.getNumberOfTeams(), 
				employerProfile.getRestrictions());
		results.next();
		employerProfile.setEmployerId(results.getInt("employer_id"));
		return employerProfile;
	}



}
