package com.techelevator.AdminFormChoice;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.EmployerProfile.model.EmployerProfile;

@Component
public class JDBCAdminChoiceDAO implements AdminChoiceDAO{

private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCAdminChoiceDAO (DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	@Override
	public void setAdminFormChoice(AdminChoice choice) {
		String insertSql = "UPDATE admin_choice SET choice = ?";
		jdbcTemplate.update(insertSql, choice.isChoice());
	}

	@Override
	public AdminChoice getAdminFormChoice() {
		String selectSql = "SELECT choice FROM admin_choice";

		SqlRowSet results = jdbcTemplate.queryForRowSet(selectSql);
		results.next();
		return mapRowToSqlResults(results);
	}

	private AdminChoice mapRowToSqlResults (SqlRowSet results) {
        AdminChoice adminChoice = new AdminChoice();
        adminChoice.setChoice(results.getBoolean("choice"));
        return adminChoice;
    }
	
}