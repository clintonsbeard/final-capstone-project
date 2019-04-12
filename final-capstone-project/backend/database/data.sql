-- *****************************************************************************
-- This script contains INSERT statements for populating tables with seed data
-- *****************************************************************************

INSERT INTO employer (company_name, company_summary, days_attending, number_of_teams, restrictions)
VALUES ('SPL Inc', 'Consultanting Firm', '2019-01-08', 1, 'NONE');

INSERT INTO employer (company_name, company_summary, days_attending, number_of_teams, restrictions)
VALUES ('BIM Inc', 'Sells Coding Advice', '2019-01-09', 1, 'NONE');

INSERT INTO employer (company_name, company_summary, days_attending, number_of_teams, restrictions)
<<<<<<< HEAD
VALUES ('SPL Inc', 'Consultanting Firm', '2019-01-08', 1, 'NONE');

INSERT INTO employer (company_name, company_summary, days_attending, number_of_teams, restrictions)
VALUES ('BIM Inc', 'Sells Coding Advice', '2019-01-09', 1, 'NONE');

INSERT INTO employer (company_name, company_summary, days_attending, number_of_teams, restrictions)
=======
>>>>>>> 607e9399db48930215615ee63ac8240d9a4e9c85
VALUES ('CJB Beardsley', 'Taking Over the World with Vue', '2019-01-08', 1, 'NONE');

INSERT INTO employer (company_name, company_summary, days_attending, number_of_teams, restrictions)
VALUES ('AEP Electric Company', 'Gas', '2019-07-01', 1, 'NONE');

<<<<<<< HEAD
INSERT INTO student (first_name, last_name, choice_1, choice_2, choice_3, choice_4) 
VALUES ('Lincoln', 'Guthrie', 'SPL Inc', 'BIM Inc', 'AEP Electric Company', 'CJB Beardsley');

INSERT INTO student (first_name, last_name, choice_1, choice_2, choice_3, choice_4) 
VALUES ('Clint', 'Beardsley', 'CJB Beardsley', 'SPL Inc', 'BIM Inc', 'AEP Electric Company');

INSERT INTO student (first_name, last_name, choice_1, choice_2, choice_3, choice_4) 
VALUES ('Stephanie', 'Lopez', 'AEP Electric Company', 'CJB Beardsley', 'SPL Inc', 'BIM Inc');

INSERT INTO student (first_name, last_name, choice_1, choice_2, choice_3, choice_4) 
VALUES ('Bindiya', 'Sameem', 'BIM Inc', 'AEP Electric Company', 'CJB Beardsley', 'SPL Inc');

COMMIT;
=======
INSERT INTO student (first_name, last_name, choice_1, choice_2, choice_3, choice_4)
VALUES ('Lincoln', 'Guthrie', 'SPL Inc', 'BIM Inc', 'AEP Electric Company', 'CJB Beardsley');

INSERT INTO student (first_name, last_name, choice_1, choice_2, choice_3, choice_4)
VALUES ('Clint', 'Beardsley', 'CJB Beardsley', 'SPL Inc', 'BIM Inc', 'AEP Electric Company');

INSERT INTO student (first_name, last_name, choice_1, choice_2, choice_3, choice_4)
VALUES ('Stephanie', 'Lopez', 'AEP Electric Company', 'CJB Beardsley', 'SPL Inc', 'BIM Inc');

INSERT INTO student (first_name, last_name, choice_1, choice_2, choice_3, choice_4)
VALUES ('Bindiya', 'Sameem', 'BIM Inc', 'AEP Electric Company', 'CJB Beardsley', 'SPL Inc')
>>>>>>> 607e9399db48930215615ee63ac8240d9a4e9c85
