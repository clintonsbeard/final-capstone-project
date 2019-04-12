
-- *************************************************************************************************
-- This script creates all of the database objects (tables, sequences, etc) for the database
-- *************************************************************************************************

BEGIN;

-- CREATE statements go here
DROP TABLE IF EXISTS app_user;
DROP TABLE IF EXISTS student_employer;
DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS employer;
DROP TABLE IF EXISTS schedule;

CREATE TABLE app_user (
  id SERIAL PRIMARY KEY,
  user_name varchar(255) NOT NULL UNIQUE,
  password varchar(32) NOT NULL,
  salt varchar(255) NOT NULL,
  role varchar(32) NOT NULL

);

CREATE TABLE student(

  student_id SERIAL PRIMARY KEY,
  first_name VARCHAR(100) NOT NULL,
  last_name VARCHAR(100) NOT NULL,
  choice_1 VARCHAR(100) NULL,
  choice_2 VARCHAR(100) NOT NULL,
  choice_3 VARCHAR(100) NOT NULL,
  choice_4 VARCHAR(100) NOT NULL
);

CREATE TABLE employer(

  employer_id SERIAL PRIMARY KEY,
  company_name VARCHAR(100) NOT NULL,
  company_summary TEXT NOT NULL,
  days_attending DATE DEFAULT '1111-11-11',
  number_of_teams INTEGER DEFAULT 0,
  restrictions TEXT DEFAULT 'None'
  
);

CREATE TABLE schedule(

  first_date_start_time TIME NOT NULL,
  first_date_end_time TIME NOT NULL,
  second_date_start_time TIME,
  second_date_end_time TIME
  
);


CREATE TABLE student_employer(
  
  selection_id SERIAL PRIMARY KEY,
  student_id INT NOT NULL,
  choice_number INT NOT NULL,
  employer_id INT NOT NULL,
        
  constraint fk_student_employer_student_id foreign key (student_id) references student(student_id),
  constraint fk_student_employer_employer_id foreign key (employer_id) references employer(employer_id)      
);

CREATE SEQUENCE sequence_1
  increment by 1
  minvalue 1
  maxvalue 4
  start with 1
  cycle
  owned by student_employer.choice_number;


--
--CREATE TABLE student_employer(
--
--  student_id INT NOT NULL,
--  employer_id INT NOT NULL,
--        
--  constraint fk_student_employer_student_id foreign key (student_id) references student(student_id),
--  constraint fk_student_employer_employer_id foreign key (employer_id) references employer(employer_id)      
--);


COMMIT;