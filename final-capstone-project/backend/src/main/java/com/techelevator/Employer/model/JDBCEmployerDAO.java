package com.techelevator.Employer.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCEmployerDAO implements EmployerDAO{

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCEmployerDAO (DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	@Override
	public Employer insertEmployerProfile(Employer employer) {
		String insertSql = "INSERT INTO employer (employer_id, company_name, company_summary, "
				+ "days_attending, number_of_teams, restrictions) "
				+ "VALUES (DEFAULT, ?, ?, ?, ?, ?) RETURNING employer_id";		
		SqlRowSet results = jdbcTemplate.queryForRowSet(insertSql, employer.getCompanyName(), 
				employer.getCompanySummary(), employer.getDaysAttending(), 
				employer.getNumberOfTeams(), employer.getRestrictions());
		results.next();
		employer.setEmployerId(results.getInt("employer_id"));
		return employer;
	}
		
	public Employer viewEmployerProfileById(int employerId) {
		
		String selectSql = "SELECT employer_id, company_name, company_summary, days_attending, " +
						   "number_of_teams, restrictions FROM employer WHERE employer_id = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(selectSql, employerId);
		results.next();
		return mapRowToSqlResults(results);
	}
	
	@Override
	public List<Employer> showAllEmployers() {
		List<Employer> listOfEmployers = new ArrayList<>();
		String selectSql = "SELECT employer_id, company_name, company_summary, days_attending, number_of_teams, restrictions FROM employer";
		SqlRowSet results = jdbcTemplate.queryForRowSet(selectSql);
		
		while(results.next()) {
			listOfEmployers.add(mapRowToSqlResults(results));
		}
		return listOfEmployers;
	}

	private Employer mapRowToSqlResults (SqlRowSet results) {
		Employer employer = new Employer();
		employer.setEmployerId(results.getInt("employer_id"));
		employer.setCompanyName(results.getString("company_name"));
		employer.setCompanySummary(results.getString("company_summary"));
		employer.setDaysAttending(results.getDate("days_attending"));
		employer.setNumberOfTeams(results.getInt("number_of_teams"));
		employer.setRestrictions(results.getString("restrictions"));
		return employer;
	}

}

