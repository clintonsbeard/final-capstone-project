package com.techelevator.Student.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;


@Component
public class JDBCStudentDAO implements StudentDAO{
    
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    public JDBCStudentDAO (DataSource datasource) {
        jdbcTemplate = new JdbcTemplate(datasource);
    }
    
    @Override
    public Student insertNewStudentChoices(Student student) {
        String insertSql = "INSERT INTO student (student_id, first_name, last_name) "
                + "VALUES (DEFAULT, ?, ?, ?, ?, ?, ?) RETURNING student_id;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(insertSql, student.getFirstName(),
                                student.getLastName());
        
        results.next();
        Integer id = results.getInt(1);
        insertStudentChoicesIntoJoinerTable(id);
        student.setStudentId(results.getInt("student_id"));

        return student;
    }

    @Override
    public List<Student> getAllRegisteredStudents() {
        List<Student> listOfStudents = new ArrayList<>();
        String selectSql = "SELECT student_id, first_name, last_name, "
                + "choice_1, choice_2, choice_3, choice_4 FROM student";
        SqlRowSet results = jdbcTemplate.queryForRowSet(selectSql);
        
        while(results.next()) {
            listOfStudents.add(mapRowToSqlResults(results));
        }
        return listOfStudents;
    }

    @Override
    public Student getStudentByName(String firstName, String lastName) {
        // TODO Auto-generated method stub
        return null;
    }
    
    private Student mapRowToSqlResults (SqlRowSet results) {
        Student student = new Student();
        student.setStudentId(results.getInt("student_id"));
        student.setFirstName(results.getString("first_name"));
        student.setLastName(results.getString("last_name"));
        student.setChoice1(results.getString("choice_1"));
        student.setChoice2(results.getString("choice_2"));
        student.setChoice3(results.getString("choice_3"));
        student.setChoice4(results.getString("choice_4"));
        return student;
    }

    private void insertStudentChoicesIntoJoinerTable(Integer id) {
        
        String insertSql1 = "INSERT INTO student_employer (student_id, CHOICE_NUMBER, employer_id) " 
                + "SELECT student_id, nextval('sequence_1'), (SELECT employer_id FROM EMPLOYER WHERE COMPANY_NAME = CHOICE_1) " 
                + "FROM STUDENT " 
                + "WHERE STUDENT_ID = ?;";
        
        jdbcTemplate.update(insertSql1, id);
                
        String insertSql2 = "INSERT INTO student_employer (student_id, CHOICE_NUMBER, employer_id) "
                + "SELECT student_id, nextval('sequence_1'), (SELECT employer_id FROM EMPLOYER WHERE COMPANY_NAME = CHOICE_2) " 
                + "FROM STUDENT " 
                + "WHERE STUDENT_ID = ?;";
        
        jdbcTemplate.update(insertSql2, id);

        
        String insertSql3 = "INSERT INTO student_employer (student_id, CHOICE_NUMBER, employer_id) "
                + "SELECT student_id, nextval('sequence_1'), (SELECT employer_id FROM EMPLOYER WHERE COMPANY_NAME = CHOICE_3) " 
                + "FROM STUDENT " 
                + "WHERE STUDENT_ID = ?;";
        
        jdbcTemplate.update(insertSql3, id);

        
        String insertSql4 = "INSERT INTO student_employer (student_id, CHOICE_NUMBER, employer_id) "
                + "SELECT student_id, nextval('sequence_1'), (SELECT employer_id FROM EMPLOYER WHERE COMPANY_NAME = CHOICE_4) " 
                + "FROM STUDENT " 
                + "WHERE STUDENT_ID = ?;";
        
        jdbcTemplate.update(insertSql4, id);
    }

}
