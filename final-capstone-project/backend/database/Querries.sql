INSERT INTO employer (employer_id, company_name, company_summary, days_attending, number_of_teams, restrictions) 
VALUES (DEFAULT, 'JKL', 'JKL', '2019-06-06', 1, 'none');

SELECT employer_id, company_name, company_summary, days_attending, number_of_teams, restrictions FROM employer;
