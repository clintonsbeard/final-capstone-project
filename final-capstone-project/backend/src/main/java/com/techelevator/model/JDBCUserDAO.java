package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.techelevator.authentication.PasswordHasher;

import org.bouncycastle.util.encoders.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCUserDAO implements UserDAO {

    private JdbcTemplate jdbcTemplate;
    private PasswordHasher passwordHasher;

    /**
     * Create a new user dao with the supplied data source and the password hasher
     * that will salt and hash all the passwords for users.
     *
     * @param dataSource an SQL data source
     * @param passwordHasher an object to salt and hash passwords
     */
    @Autowired
    public JDBCUserDAO(DataSource dataSource, PasswordHasher passwordHasher) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.passwordHasher = passwordHasher;
    }

    /**
     * Save a new user to the database. The password that is passed in will be
     * salted and hashed before being saved. The original password is never
     * stored in the system. We will never have any idea what it is!
     *
     * @param userName the user name to give the new user
     * @param password the user's password
     * @param role the user's role
     * @return the new user
     */
    @Override
    public User saveUser(String userName, String password, String role) {
        byte[] salt = passwordHasher.generateRandomSalt();
        String hashedPassword = passwordHasher.computeHash(password, salt);
        String saltString = new String(Base64.encode(salt));
        long newId = jdbcTemplate.queryForObject("INSERT INTO app_user(user_name, password, salt, role) VALUES (?, ?, ?, ?) RETURNING id", Long.class, userName.toLowerCase(),
                hashedPassword, saltString, role.toLowerCase());

        User newUser = new User();
        newUser.setId(newId);
        newUser.setUsername(userName);
        newUser.setRole(role);

        return newUser;
    }

    @Override
    public void changePassword(User user, String newPassword) {
        byte[] salt = passwordHasher.generateRandomSalt();
        String hashedPassword = passwordHasher.computeHash(newPassword, salt);
        String saltString = new String(Base64.encode(salt));

        jdbcTemplate.update("UPDATE app_user SET password=?, salt=? WHERE id=?",
                hashedPassword, saltString, user.getId());
    }

    /**
     * Look for a user with the given username and password. Since we don't
     * know the password, we will have to get the user's salt from the database,
     * hash the password, and compare that against the hash in the database.
     *
     * @param userName the user name of the user we are checking
     * @param password the password of the user we are checking
     * @return true if the user is found and their password matches
     */
    @Override
    public User getValidUserWithPassword(String userName, String password) {
        String sqlSearchForUser = "SELECT * FROM app_user WHERE LOWER(user_name) = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchForUser, userName.toLowerCase());
        if (results.next()) {
            String storedSalt = results.getString("salt");
            String storedPassword = results.getString("password");
            String hashedPassword = passwordHasher.computeHash(password, Base64.decode(storedSalt));
            if(storedPassword.equals(hashedPassword)) {
                return mapResultToUser(results);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * Get all of the users from the database.
     * @return a List of user objects
     */
    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        String sqlSelectAllUsers = "SELECT id, user_name, role FROM app_user";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllUsers);

        while(results.next()) {
            User user = mapResultToUser(results);
            users.add(user);
        }

        return users;
    }

    private User mapResultToUser(SqlRowSet results) {
        User user = new User();
        user.setId(results.getLong("id"));
        user.setUsername(results.getString("user_name"));
        user.setRole(results.getString("role"));
        return user;
    }

    @Override
    public User getUserByUsername(String username) {
        String sqlSelectUserByUsername = "SELECT id, user_name, role FROM app_user WHERE user_name = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectUserByUsername, username);

        if(results.next()) {
            return mapResultToUser(results);
        } else {
            return null;
        }
    }

}
