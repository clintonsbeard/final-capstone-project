-- *************************************************************************************************
-- This script creates all of the database objects (tables, sequences, etc) for the database
-- *************************************************************************************************

BEGIN;

-- CREATE statements go here
DROP TABLE IF EXISTS app_user;
DROP TABLE IF EXISTS student_employer;
DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS employer;

CREATE TABLE app_user (
  id SERIAL PRIMARY KEY,
  user_name varchar(32) NOT NULL UNIQUE,
  password varchar(32) NOT NULL,
  role varchar(32),
  salt varchar(255) NOT NULL
);

CREATE TABLE student(

  student_id SERIAL PRIMARY KEY,
  first_name VARCHAR(100) NOT NULL,
  last_name VARCHAR(100) NOT NULL,
  choice_1 INTEGER NOT NULL,
  choice_2 INTEGER NOT NULL,
  choice_3 INTEGER NOT NULL,
  choice_4 INTEGER NOT NULL
);

CREATE TABLE employer(

  employer_id SERIAL PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  last_name VARCHAR(100) NOT NULL,
  logo VARCHAR(100),
  information TEXT NOT NULL,
  number_of_teams INTEGER NOT NULL
);


CREATE TABLE student_employer(

  student_id INT NOT NULL,
  employer_id INT NOT NULL,
        
  constraint fk_student_employer_student_id foreign key (student_id) references student(student_id),
  constraint fk_student_employer_employer_id foreign key (employer_id) references employer(employer_id)      
);


COMMIT;