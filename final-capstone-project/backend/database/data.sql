-- *****************************************************************************
-- This script contains INSERT statements for populating tables with seed data
-- *****************************************************************************

INSERT INTO app_user (user_name, password, salt, role) 
VALUES ('admin', 'jy072QcO/8+CBk2Zdo2jVQ==', 'YOTgqH3wx3OfAUugPhLjwtWcsH/GQuo+pFIwTgYxsut24oJkBrLe/Ha+gFRGqHL/16dhJkR+QVfrSyi05vro69mE8tKpyQ8MiyWF6eGIzvpZ7HcOjzcFswn/3x17hwfzUXgNEyUu3URLmWDXMN3aVLwj7ZQEYkG+GktVUzhfpxQ=', 'admin');

INSERT INTO app_user (user_name, password, salt, role) 
VALUES ('dvega', 'FjZDm+sndmsdEDwNtfr6NA==', 'kidcasB0te7i0jK0fmRIGHSm0mYhdLTaiGkEAiEvLp7dAEHWnuT8n/5bd2V/mqjstQ198iImm1xCmEFu+BHyOz1Mf7vm4LILcrr17y7Ws40Xyx4FOCt8jD03G+jEafpuVJnPiDmaZQXJEpEfekGOvhKGOCtBnT5uatjKEuVWuDA=', 'student');

INSERT INTO employer (company_name, company_summary, days_attending, number_of_teams, restrictions)
VALUES ('SPL Inc', 'Consultanting Firm', '2019-01-08', 1, 'None');

INSERT INTO employer (company_name, company_summary, days_attending, number_of_teams, restrictions)
VALUES ('BIM Inc', 'Sells Coding Advice', '2019-01-09', 1, 'None');

INSERT INTO employer (company_name, company_summary, days_attending, number_of_teams, restrictions)
VALUES ('CJB Beardsley', 'Taking Over the World with Vue', '2019-01-08', 1, 'None');

INSERT INTO employer (company_name, company_summary, days_attending, number_of_teams, restrictions)
VALUES ('AEP Electric Company', 'Gas', '2019-07-01', 1, 'None');

INSERT INTO employer (company_name, company_summary, days_attending, number_of_teams, restrictions)
VALUES ('Stepdad Corporation', 'Sorry', '2019-01-02', 3, 'Lactose Intolerant');

INSERT INTO employer (company_name, company_summary, days_attending, number_of_teams, restrictions)
VALUES ('AEP Electric Company', 'Gas', '2019-07-01', 1, 'NONE');

INSERT INTO employer (company_name, company_summary, days_attending, number_of_teams, restrictions)
VALUES ('Potatoes', 'We got em', '2019-01-08', 1, 'None');

INSERT INTO employer (company_name, company_summary, days_attending, number_of_teams, restrictions)
VALUES ('Omni Consumer Products', 'Yeah, the company from Robocop', '2019-01-09', 1, 'None');

INSERT INTO employer (company_name, company_summary, days_attending, number_of_teams, restrictions)
VALUES ('Company', 'Product', '2019-01-08', 1, 'None');

INSERT INTO employer (company_name, company_summary, days_attending, number_of_teams, restrictions)
VALUES ('Tech Elevator', 'Not an elevator repair school', '2019-07-01', 1, 'None');

INSERT INTO employer (company_name, company_summary, days_attending, number_of_teams, restrictions)
VALUES ('The Picture of Dorian Gray', 'Don''t do it', '2019-01-02', 3, 'Yes');

INSERT INTO student (first_name, last_name, choice_1, choice_2, choice_3, choice_4) 
VALUES ('Lincoln', 'Guthrie', 'SPL Inc', 'BIM Inc', 'AEP Electric Company', 'CJB Beardsley');

INSERT INTO student (first_name, last_name, choice_1, choice_2, choice_3, choice_4) 
VALUES ('Clint', 'Beardsley', 'CJB Beardsley', 'SPL Inc', 'BIM Inc', 'AEP Electric Company');

INSERT INTO student (first_name, last_name, choice_1, choice_2, choice_3, choice_4) 
VALUES ('Stephanie', 'Lopez', 'AEP Electric Company', 'CJB Beardsley', 'SPL Inc', 'BIM Inc');

INSERT INTO student (first_name, last_name, choice_1, choice_2, choice_3, choice_4) 
VALUES ('Bindiya', 'Sameem', 'BIM Inc', 'AEP Electric Company', 'CJB Beardsley', 'SPL Inc');

--INSERT INTO student_employer (student_id, choice_number, employer_id)
--SELECT STUDENT_ID, NEXTVAL('sequence_1'), (SELECT employer_id FROM EMPLOYER WHERE COMPANY_NAME = CHOICE_1)
--FROM STUDENT
--WHERE student_id = 1;
--
--INSERT INTO student_employer (student_id, choice_number, employer_id)
--SELECT STUDENT_ID, NEXTVAL('sequence_1'), (SELECT employer_id FROM EMPLOYER WHERE COMPANY_NAME = CHOICE_2)
--FROM STUDENT
--WHERE student_id = 1;
--
--INSERT INTO student_employer (student_id, choice_number, employer_id)
--SELECT STUDENT_ID, NEXTVAL('sequence_1'), (SELECT employer_id FROM EMPLOYER WHERE COMPANY_NAME = CHOICE_3)
--FROM STUDENT
--WHERE student_id = 1;
--
--INSERT INTO student_employer (student_id, choice_number, employer_id)
--SELECT STUDENT_ID, NEXTVAL('sequence_1'), (SELECT employer_id FROM EMPLOYER WHERE COMPANY_NAME = CHOICE_4)
--FROM STUDENT
--WHERE student_id = 1;
--
--INSERT INTO STUDENT_EMPLOYER (STUDENT_ID, CHOICE_NUMBER, EMPLOYER_ID)
--SELECT STUDENT_ID, NEXTVAL('sequence_1'), (SELECT EMPLOYER_ID FROM EMPLOYER WHERE COMPANY_NAME = CHOICE_1)
--FROM STUDENT
--WHERE STUDENT_ID = 2;
--
--INSERT INTO STUDENT_EMPLOYER (STUDENT_ID, CHOICE_NUMBER, EMPLOYER_ID)
--SELECT STUDENT_ID, NEXTVAL('sequence_1'), (SELECT EMPLOYER_ID FROM EMPLOYER WHERE COMPANY_NAME = CHOICE_2)
--FROM STUDENT
--WHERE STUDENT_ID = 2;
--
--INSERT INTO STUDENT_EMPLOYER (STUDENT_ID, CHOICE_NUMBER, EMPLOYER_ID)
--SELECT STUDENT_ID, NEXTVAL('sequence_1'), (SELECT EMPLOYER_ID FROM EMPLOYER WHERE COMPANY_NAME = CHOICE_3)
--FROM STUDENT
--WHERE STUDENT_ID = 2;
--
--INSERT INTO STUDENT_EMPLOYER (STUDENT_ID, CHOICE_NUMBER, EMPLOYER_ID)
--SELECT STUDENT_ID, NEXTVAL('sequence_1'), (SELECT EMPLOYER_ID FROM EMPLOYER WHERE COMPANY_NAME = CHOICE_4)
--FROM STUDENT
--WHERE STUDENT_ID = 2;
--
--INSERT INTO STUDENT_EMPLOYER (STUDENT_ID, CHOICE_NUMBER, EMPLOYER_ID)
--SELECT STUDENT_ID, NEXTVAL('sequence_1'), (SELECT EMPLOYER_ID FROM EMPLOYER WHERE COMPANY_NAME = CHOICE_1)
--FROM STUDENT
--WHERE STUDENT_ID = 3;
--
--INSERT INTO STUDENT_EMPLOYER (STUDENT_ID, CHOICE_NUMBER, EMPLOYER_ID)
--SELECT STUDENT_ID, NEXTVAL('sequence_1'), (SELECT EMPLOYER_ID FROM EMPLOYER WHERE COMPANY_NAME = CHOICE_2)
--FROM STUDENT
--WHERE STUDENT_ID = 3;
--
--INSERT INTO STUDENT_EMPLOYER (STUDENT_ID, CHOICE_NUMBER, EMPLOYER_ID)
--SELECT STUDENT_ID, NEXTVAL('sequence_1'), (SELECT EMPLOYER_ID FROM EMPLOYER WHERE COMPANY_NAME = CHOICE_3)
--FROM STUDENT
--WHERE STUDENT_ID = 3;
--
--INSERT INTO STUDENT_EMPLOYER (STUDENT_ID, CHOICE_NUMBER, EMPLOYER_ID)
--SELECT STUDENT_ID, NEXTVAL('sequence_1'), (SELECT EMPLOYER_ID FROM EMPLOYER WHERE COMPANY_NAME = CHOICE_4)
--FROM STUDENT
--WHERE STUDENT_ID = 3;
--
--INSERT INTO STUDENT_EMPLOYER (STUDENT_ID, CHOICE_NUMBER, EMPLOYER_ID)
--SELECT STUDENT_ID, NEXTVAL('sequence_1'), (SELECT EMPLOYER_ID FROM EMPLOYER WHERE COMPANY_NAME = CHOICE_1)
--FROM STUDENT
--WHERE STUDENT_ID = 4;
--
--INSERT INTO STUDENT_EMPLOYER (STUDENT_ID, CHOICE_NUMBER, EMPLOYER_ID)
--SELECT STUDENT_ID, NEXTVAL('sequence_1'), (SELECT EMPLOYER_ID FROM EMPLOYER WHERE COMPANY_NAME = CHOICE_2)
--FROM STUDENT
--WHERE STUDENT_ID = 4;
--
--INSERT INTO STUDENT_EMPLOYER (STUDENT_ID, CHOICE_NUMBER, EMPLOYER_ID)
--SELECT STUDENT_ID, NEXTVAL('sequence_1'), (SELECT EMPLOYER_ID FROM EMPLOYER WHERE COMPANY_NAME = CHOICE_3)
--FROM STUDENT
--WHERE STUDENT_ID = 4;
--
--INSERT INTO STUDENT_EMPLOYER (STUDENT_ID, CHOICE_NUMBER, EMPLOYER_ID)
--SELECT STUDENT_ID, NEXTVAL('sequence_1'), (SELECT EMPLOYER_ID FROM EMPLOYER WHERE COMPANY_NAME = CHOICE_4)
--FROM STUDENT
--WHERE STUDENT_ID = 4;

INSERT INTO admin_choice (choice)
VALUES (false);

COMMIT;


