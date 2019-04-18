-- *****************************************************************************
-- This script contains INSERT statements for populating tables with seed data
-- *****************************************************************************

INSERT INTO app_user (user_name, password, salt, role) 
VALUES ('admin', 'jy072QcO/8+CBk2Zdo2jVQ==', 'YOTgqH3wx3OfAUugPhLjwtWcsH/GQuo+pFIwTgYxsut24oJkBrLe/Ha+gFRGqHL/16dhJkR+QVfrSyi05vro69mE8tKpyQ8MiyWF6eGIzvpZ7HcOjzcFswn/3x17hwfzUXgNEyUu3URLmWDXMN3aVLwj7ZQEYkG+GktVUzhfpxQ=', 'admin');

INSERT INTO app_user (user_name, password, salt, role) 
VALUES ('student2', 'ySOmxLWszlMWFhY7tuYDiA==', 'UWQZhSC9oggLcGnNl9JcCBKDzJ158AQqTbW9xhGeHsijDFjei3fZxG6qKKuvYRVF7pdBIr6FE+Ib+tvKMyxufc9O2A84mbfQHeXXba+RH7GoWUvyU+bg0f0bo/r6j/8s1KXJTTMgYR/+1IsMhLAIsGv7THkWRHvEBaXaxsXoXT0=', 'student');

INSERT INTO app_user (user_name, password, salt, role) 
VALUES ('employer3', 'ILxasvfUJbsPvVxw6XLsqw==', 'F2NJfNgiCbKbKTkOOqriKfrlj7jc/pkYzPiz+SMaIjLUMQFS4eixzy8ropUO0U3a/W/ExXTLW13RmXcKqS039q+2zfiBnUWPZO/rCNpH3MredodS6BkknAvaIWpBiwN94O1+/qy+4xDRRjdIZsIGhngtrPGYsuVDo/W6BP1Ptac=', 'employer');

---Employers

INSERT INTO employer (company_name, company_summary, email, website, positions_summary, path_preference, number_of_teams, restrictions)
VALUES ('SPL Inc', 'Consulting Firm', 'test@test.com', 'http://www.test.com', 'We got jobz', 'Java', 1, 'None');

INSERT INTO employer (company_name, company_summary, email, website, positions_summary, path_preference, number_of_teams, restrictions)
VALUES ('BIM Inc', 'Sells Coding Advice', 'test@test.com', 'http://www.test.com', 'We got jobz', 'Java', 1, 'None');

INSERT INTO employer (company_name, company_summary, email, website, positions_summary, path_preference, number_of_teams, restrictions)
VALUES ('CJB Beardsley', 'Taking Over the World with Vue', 'test@test.com', 'http://www.test.com', 'We got jobz', 'Java', 2, 'None');

INSERT INTO employer (company_name, company_summary, email, website, positions_summary, path_preference, number_of_teams, restrictions)
VALUES ('Postman', 'API Development Environment', 'test@test.com', 'http://www.test.com', 'Postman an API Develpment Environmen that flexibly integrates with the software development cycle', 'Java', 1, 'None');

INSERT INTO employer (company_name, company_summary, email, website, positions_summary, path_preference, number_of_teams, restrictions)
VALUES ('Stepdad Corporation', 'Sorry', 'test@test.com', 'http://www.test.com', 'We got jobz', 'Java', 1, 'Lactose Intolerant');

INSERT INTO employer (company_name, company_summary, email, website, positions_summary, path_preference, number_of_teams, restrictions)
VALUES ('AEP Electric Company', 'Gas', 'test@test.com', 'http://www.test.com', 'We got jobz', 'Java', 1, 'NONE');

INSERT INTO employer (company_name, company_summary, email, website, positions_summary, path_preference, number_of_teams, restrictions)
VALUES ('Potatoes', 'We got em', 'test@test.com', 'http://www.test.com', 'We got jobz', 'Java', 1, 'None');

INSERT INTO employer (company_name, company_summary, email, website, positions_summary, path_preference, number_of_teams, restrictions)
VALUES ('Omni Consumer Products', 'Yeah, the company from Robocop', 'test@test.com', 'http://www.test.com', 'We got jobz', 'Java', 1, 'None');

INSERT INTO employer (company_name, company_summary, email, website, positions_summary, path_preference, number_of_teams, restrictions)
VALUES ('Company', 'Product', 'test@test.com', 'http://www.test.com', 'We got jobz', 'Java', 1, 'None');

INSERT INTO employer (company_name, company_summary, email, website, positions_summary, path_preference, number_of_teams, restrictions)
VALUES ('Tech Elevator', 'Not an elevator repair school', 'test@test.com', 'http://www.test.com', 'We got jobz', 'Java', 1, 'None');

INSERT INTO employer (company_name, company_summary, email, website, positions_summary, path_preference, number_of_teams, restrictions)
VALUES ('The Picture of Dorian Gray', 'Don''t do it', 'test@test.com', 'http://www.test.com', 'We got jobz', 'Java', 1, 'Yes');

---- Students

INSERT INTO student (first_name, last_name) 
VALUES ('Lincoln', 'Guthrie');

INSERT INTO student (first_name, last_name) 
VALUES ('Clint', 'Beardsley');

INSERT INTO student (first_name, last_name) 
VALUES ('Stephanie', 'Lopez');

INSERT INTO student (first_name, last_name) 
VALUES ('Bindiya', 'Sameem');

INSERT INTO student (first_name, last_name) 
VALUES ('James', 'Cameron');

INSERT INTO student (first_name, last_name) 
VALUES ('Alex', 'Harty');

INSERT INTO student (first_name, last_name) 
VALUES ('Quinn', 'Sprouse');

INSERT INTO student (first_name, last_name) 
VALUES ('Caitlin', 'Ho');

INSERT INTO student (first_name, last_name) 
VALUES ('Ty', 'Owens');

INSERT INTO student (first_name, last_name) 
VALUES ('Anish', 'Niroula');

INSERT INTO student (first_name, last_name) 
VALUES ('Dominick', 'Hemphill');

----Top 4 INSERTS

INSERT INTO student_employer_top_four (student_id, employer_id, choice_number) 
VALUES (1, 1, 1);

INSERT INTO student_employer_top_four (student_id, employer_id, choice_number) 
VALUES (1, 2, 2);

INSERT INTO student_employer_top_four (student_id, employer_id, choice_number) 
VALUES (1, 3, 3);

INSERT INTO student_employer_top_four (student_id, employer_id, choice_number) 
VALUES (1, 4, 4);

INSERT INTO student_employer_top_four (student_id, employer_id, choice_number) 
VALUES (2, 2, 1);

INSERT INTO student_employer_top_four (student_id, employer_id, choice_number) 
VALUES (2, 3, 2);

INSERT INTO student_employer_top_four (student_id, employer_id, choice_number) 
VALUES (2, 4, 3);

INSERT INTO student_employer_top_four (student_id, employer_id, choice_number) 
VALUES (2, 1, 4);

INSERT INTO student_employer_top_four (student_id, employer_id, choice_number) 
VALUES (3, 3, 1);

INSERT INTO student_employer_top_four (student_id, employer_id, choice_number) 
VALUES (3, 4, 2);

INSERT INTO student_employer_top_four (student_id, employer_id, choice_number) 
VALUES (3, 1, 3);

INSERT INTO student_employer_top_four (student_id, employer_id, choice_number) 
VALUES (3, 2, 4);

INSERT INTO student_employer_top_four (student_id, employer_id, choice_number) 
VALUES (4, 4, 1);

INSERT INTO student_employer_top_four (student_id, employer_id, choice_number) 
VALUES (4, 1, 2);

INSERT INTO student_employer_top_four (student_id, employer_id, choice_number) 
VALUES (4, 2, 3);

INSERT INTO student_employer_top_four (student_id, employer_id, choice_number) 
VALUES (4, 3, 4);

INSERT INTO student_employer_top_four (student_id, employer_id, choice_number) 
VALUES (5, 11, 1);

INSERT INTO student_employer_top_four (student_id, employer_id, choice_number) 
VALUES (5, 9, 2);

INSERT INTO student_employer_top_four (student_id, employer_id, choice_number) 
VALUES (5, 7, 3);

INSERT INTO student_employer_top_four (student_id, employer_id, choice_number) 
VALUES (5, 8, 4);

INSERT INTO student_employer_top_four (student_id, employer_id, choice_number) 
VALUES (6, 7, 1);

INSERT INTO student_employer_top_four (student_id, employer_id, choice_number) 
VALUES (6, 2, 2);

INSERT INTO student_employer_top_four (student_id, employer_id, choice_number) 
VALUES (6, 6, 3);

INSERT INTO student_employer_top_four (student_id, employer_id, choice_number) 
VALUES (6, 4, 4);

INSERT INTO student_employer_top_four (student_id, employer_id, choice_number) 
VALUES (7, 8, 1);

INSERT INTO student_employer_top_four (student_id, employer_id, choice_number) 
VALUES (7, 2, 2);

INSERT INTO student_employer_top_four (student_id, employer_id, choice_number) 
VALUES (7, 5, 3);

INSERT INTO student_employer_top_four (student_id, employer_id, choice_number) 
VALUES (7, 11, 4);

INSERT INTO student_employer_top_four (student_id, employer_id, choice_number) 
VALUES (8, 3, 1);

INSERT INTO student_employer_top_four (student_id, employer_id, choice_number) 
VALUES (8, 4, 2);

INSERT INTO student_employer_top_four (student_id, employer_id, choice_number) 
VALUES (8, 1, 3);

INSERT INTO student_employer_top_four (student_id, employer_id, choice_number) 
VALUES (8, 2, 4);

INSERT INTO student_employer_top_four (student_id, employer_id, choice_number) 
VALUES (9, 9, 1);

INSERT INTO student_employer_top_four (student_id, employer_id, choice_number) 
VALUES (9, 10, 2);

INSERT INTO student_employer_top_four (student_id, employer_id, choice_number) 
VALUES (9, 11, 3);

INSERT INTO student_employer_top_four (student_id, employer_id, choice_number) 
VALUES (9, 2, 4);

INSERT INTO student_employer_top_four (student_id, employer_id, choice_number) 
VALUES (10, 3, 1);

INSERT INTO student_employer_top_four (student_id, employer_id, choice_number) 
VALUES (10, 4, 2);

INSERT INTO student_employer_top_four (student_id, employer_id, choice_number) 
VALUES (10, 1, 3);

INSERT INTO student_employer_top_four (student_id, employer_id, choice_number) 
VALUES (10, 2, 4);

INSERT INTO student_employer_top_four (student_id, employer_id, choice_number) 
VALUES (11, 3, 1);

INSERT INTO student_employer_top_four (student_id, employer_id, choice_number) 
VALUES (11, 4, 2);

INSERT INTO student_employer_top_four (student_id, employer_id, choice_number) 
VALUES (11, 1, 3);

INSERT INTO student_employer_top_four (student_id, employer_id, choice_number) 
VALUES (11, 2, 4);

--RANK ALL INSERTS

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (1, 1, 1);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (1, 2, 2);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (1, 3, 3);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (1, 4, 4);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (1, 5, 5);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (1, 6, 6);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (1, 7, 7);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (1, 8, 8);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (1, 9, 9);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (1, 10, 10);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (2, 2, 1);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (2, 3, 2);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (2, 4, 3);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (2, 5, 4);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (2, 6, 5);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (2, 7, 6);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (2, 8, 7);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (2, 9, 8);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (2, 10, 9);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (2, 1, 10);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (3, 3, 1);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (3, 4, 2);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (3, 5, 3);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (3, 6, 4);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (3, 7, 5);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (3, 8, 6);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (3, 9, 7);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (3, 10, 8);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (3, 1, 9);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (3, 2, 10);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (4, 4, 1);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (4, 5, 2);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (4, 6, 3);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (4, 7, 4);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (4, 8, 5);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (4, 9, 6);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (4, 10, 7);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (4, 1, 8);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (4, 2, 9);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (4, 3, 10);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (5, 3, 1);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (5, 4, 2);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (5, 5, 3);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (5, 6, 4);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (5, 7, 5);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (5, 8, 6);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (5, 9, 7);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (5, 10, 8);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (5, 1, 9);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (5, 2, 10);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (6, 3, 1);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (6, 4, 2);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (6, 5, 3);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (6, 6, 4);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (6, 7, 5);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (6, 8, 6);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (6, 9, 7);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (6, 10, 8);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (6, 1, 9);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (6, 2, 10);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (7, 3, 1);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (7, 4, 2);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (7, 5, 3);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (7, 6, 4);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (7, 7, 5);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (7, 8, 6);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (7, 9, 7);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (7, 10, 8);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (7, 1, 9);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (7, 2, 10);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (8, 3, 1);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (8, 4, 2);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (8, 5, 3);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (8, 6, 4);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (8, 7, 5);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (8, 8, 6);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (8, 9, 7);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (8, 10, 8);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (8, 1, 9);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (8, 2, 10);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (9, 3, 1);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (9, 4, 2);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (9, 5, 3);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (9, 6, 4);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (9, 7, 5);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (9, 8, 6);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (9, 9, 7);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (9, 10, 8);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (9, 1, 9);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (9, 2, 10);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (10, 3, 1);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (10, 4, 2);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (10, 5, 3);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (10, 6, 4);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (10, 7, 5);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (10, 8, 6);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (10, 9, 7);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (10, 10, 8);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (10, 1, 9);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (10, 2, 10);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (11, 3, 1);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (11, 4, 2);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (11, 5, 3);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (11, 6, 4);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (11, 7, 5);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (11, 8, 6);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (11, 9, 7);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (11, 10, 8);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (11, 1, 9);

INSERT INTO student_employer_rank_all (student_id, employer_id, choice_number) 
VALUES (11, 2, 10);

---Schedule

INSERT INTO schedule (schedule_id, matchmaking_date, start_time, end_time, interview_length, break_start_time, break_end_time) 
VALUES (1, '2019-06-24', '14:00:00', '18:00:00', 30, '16:00:00', '16:30:00');

INSERT INTO schedule (schedule_id, matchmaking_date, start_time, end_time, interview_length, break_start_time, break_end_time) 
VALUES (2, '2019-06-25', '13:00:00', '18:00:00', 30, '15:00:00', '15:30:00');

----Employer Schedule

INSERT INTO employer_schedule (employer_id, schedule_id) 
VALUES (1, 1);

INSERT INTO employer_schedule (employer_id, schedule_id) 
VALUES (2, 2);

INSERT INTO employer_schedule (employer_id, schedule_id) 
VALUES (3, 1);

INSERT INTO employer_schedule (employer_id, schedule_id) 
VALUES (3, 2);

INSERT INTO employer_schedule (employer_id, schedule_id) 
VALUES (4, 1);

INSERT INTO employer_schedule (employer_id, schedule_id) 
VALUES (5, 1);

INSERT INTO employer_schedule (employer_id, schedule_id) 
VALUES (6, 2);

INSERT INTO employer_schedule (employer_id, schedule_id) 
VALUES (7, 1);

INSERT INTO employer_schedule (employer_id, schedule_id) 
VALUES (8, 2);

INSERT INTO employer_schedule (employer_id, schedule_id) 
VALUES (9, 2);

INSERT INTO employer_schedule (employer_id, schedule_id) 
VALUES (10, 1);

---Admin Choice

INSERT INTO admin_choice (choice)
VALUES (false);