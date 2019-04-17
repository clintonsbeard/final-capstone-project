package com.techelevator.EmployerProfile.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.StudentAll.model.StudentAll;

@Component
public class JDBCEmployerProfileDAO implements EmployerProfileDAO{

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCEmployerProfileDAO (DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	@Override
	public EmployerProfile insertEmployerProfile(EmployerProfile employerProfile) {
		String insertSql = "INSERT INTO employer (company_name, company_summary, email, website, positions_summary, " + 
						   "path_preference, number_of_teams, restrictions) " +
						   "VALUES (?, ?, ?, ?, ?, ?, ?, ?) RETURNING employer_id";
		SqlRowSet results = jdbcTemplate.queryForRowSet(insertSql, employerProfile.getCompanyName(), 
				employerProfile.getCompanySummary(), employerProfile.getEmail(), 
				employerProfile.getWebsite(), employerProfile.getPositionsSummary(),
				employerProfile.getPathPreference(), employerProfile.getNumberOfTeams(),
				employerProfile.getRestrictions());
		results.next();
		Integer employerId = results.getInt(1);
		for(int i = 0; i < employerProfile.getDaysAttending().length; i++) {
			String updateSql = "INSERT INTO employer_schedule (employer_id, schedule_id) VALUES (?, ?);";
			if (employerProfile.getDaysAttending()[i]) {
				jdbcTemplate.update(updateSql, employerId, i + 1);
			}
		}
		employerProfile.setEmployerId(results.getInt("employer_id"));
		return employerProfile;
	}
		
	@Override
	public EmployerProfile viewEmployerProfile(int employerId) {
		
		String selectSql = "SELECT employer_id, company_name, company_summary, email, website, " +
						   "positions_summary, path_preference, number_of_teams, restrictions " +
						   "FROM employer WHERE employer_id = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(selectSql, employerId);
		results.next();
		return mapRowToSqlResults(results);
	}
	
	@Override
	public List<EmployerProfile> showAllEmployers() {
		List<EmployerProfile> listOfEmployers = new ArrayList<>();
		String selectSql = "SELECT employer_id, company_name, company_summary, email, website, " + 
						   "positions_summary, path_preference, number_of_teams, restrictions " + 
						   "FROM employer ORDER BY employer_id";
		SqlRowSet results = jdbcTemplate.queryForRowSet(selectSql);
		
		while(results.next()) {
			listOfEmployers.add(mapRowToSqlResults(results));
		}
		return listOfEmployers;
	}
	
	@Override
	public List<EmployerProfile> showEmployersForScheduleId(int employerId) {
		List<EmployerProfile> listOfEmployers = new ArrayList<>();
		String selectSql = "SELECT employer.employer_id, employer.company_name FROM employer " 
				+ "JOIN employer_schedule on employer.employer_id = employer_schedule.employer_id " 
				+ "WHERE employer_schedule.schedule_id = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(selectSql, employerId);
		
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
        empProf.setEmail(results.getString("email"));
        empProf.setWebsite(results.getString("website"));
        empProf.setPositionsSummary(results.getString("positions_summary"));
        empProf.setPathPreference(results.getString("path_preference"));
        empProf.setNumberOfTeams(results.getInt("number_of_teams"));
        empProf.setRestrictions(results.getString("restrictions"));
        return empProf;
    }

    @Override
    public EmployerProfile updateEmployerProfile(EmployerProfile employerProfile) {
        String updateSql = "UPDATE employer SET company_name = ?, company_summary = ?, email = ?, website = ?, " +
        				   "positions_summary = ?, path_preference = ?, number_of_teams = ?, " +
                           "restrictions = ? WHERE employer_id = ?";
        jdbcTemplate.update(updateSql, employerProfile.getCompanyName(), employerProfile.getCompanySummary(),
                employerProfile.getEmail(), employerProfile.getWebsite(), employerProfile.getPositionsSummary(), 
                employerProfile.getPathPreference(), employerProfile.getNumberOfTeams(), employerProfile.getRestrictions(), 
                employerProfile.getEmployerId());
        return employerProfile;
    }
    
    private EmployerProfile mapRowToSqlResultsById (SqlRowSet results) {
        EmployerProfile empProf = new EmployerProfile();
        empProf.setEmployerId(results.getInt("employer_id"));
        empProf.setCompanyName(results.getString("company_name"));
        
        return empProf;
    }
    
    @Override
    public List<EmployerProfile> showEmployersByScheduleId(int scheduleId) {
        List<EmployerProfile> listOfEmployers = new ArrayList<>();
        String selectSql = "SELECT employer.employer_id, employer.company_name FROM employer " 
                + "JOIN employer_schedule on employer.employer_id = employer_schedule.employer_id " 
                + "WHERE employer_schedule.schedule_id = ?";
        
        SqlRowSet results = jdbcTemplate.queryForRowSet(selectSql, scheduleId);
        
        while(results.next()) {
            listOfEmployers.add(mapRowToSqlResultsById(results));
        }
        return listOfEmployers;
    }
    
}