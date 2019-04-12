package com.techelevator.EmployerProfile.model;

import java.util.ArrayList;
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
	public EmployerProfile insertEmployerProfile(EmployerProfile employerProfile) {
		String insertSql = "INSERT INTO employer (employer_id, company_name, company_summary, " +
						   "days_attending, number_of_teams, restrictions) " +
						   "VALUES (DEFAULT, ?, ?, ?, ?, ?) RETURNING employer_id";
		SqlRowSet results = jdbcTemplate.queryForRowSet(insertSql, employerProfile.getCompanyName(), 
				employerProfile.getCompanySummary(), employerProfile.getDaysAttending(), 
				employerProfile.getNumberOfTeams(), employerProfile.getRestrictions());
		results.next();
		employerProfile.setEmployerId(results.getInt("employer_id"));
		return employerProfile;
	}
		
	public EmployerProfile viewEmployerProfile(int employerId) {
		
		String selectSql = "SELECT employer_id, company_name, company_summary, days_attending, " +
						   "number_of_teams, restrictions FROM employer WHERE employer_id = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(selectSql, employerId);
		results.next();
		return mapRowToSqlResults(results);
	}
	
	@Override
	public List<EmployerProfile> showAllEmployers() {
		List<EmployerProfile> listOfEmployers = new ArrayList<>();
		String selectSql = "SELECT employer_id, company_name, company_summary, days_attending, number_of_teams, restrictions FROM employer";
		SqlRowSet results = jdbcTemplate.queryForRowSet(selectSql);
		
		while(results.next()) {
			listOfEmployers.add(mapRowToSqlResults(results));
		}
		return listOfEmployers;
	}

    private EmployerProfile mapRowToSqlResults (SqlRowSet results) {
        EmployerProfile empProf = new EmployerProfile();
        empProf.setEmployerId(results.getInt("employer_id"));
        empProf.setCompanyName(results.getString("company_name"));
        empProf.setCompanySummary(results.getString("company_summary"));
        empProf.setDaysAttending(results.getDate("days_attending").toLocalDate());
        empProf.setNumberOfTeams(results.getInt("number_of_teams"));
        empProf.setRestrictions(results.getString("restrictions"));
        return empProf;
    }

    @Override
    public EmployerProfile updateEmployerProfile(EmployerProfile employerProfile) {
        String updateSql = "UPDATE employer SET company_name = ?, company_summary = ?, days_attending = ?, number_of_teams = ?, " +
                           "restrictions = ? WHERE employer_id = ?";
        jdbcTemplate.update(updateSql, employerProfile.getCompanyName(), 
                employerProfile.getCompanySummary(), employerProfile.getDaysAttending(), 
                employerProfile.getNumberOfTeams(), employerProfile.getRestrictions(), 
                employerProfile.getEmployerId());
        return employerProfile;
    }
    
}