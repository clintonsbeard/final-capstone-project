 INSERT INTO person (person_id, first_name, last_name, date_added, type, update_date) 
VALUES (DEFAULT, ?, ?, ?, ?, ?) RETURNING person_id