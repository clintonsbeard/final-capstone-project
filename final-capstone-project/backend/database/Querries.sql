SELECT * FROM student
JOIN student_employer_top_four ON student_employer_top_four.student_id = student.student_id
JOIN employer ON employer.employer_id = student_employer_top_four.employer_id
JOIN employer_schedule ON employer_schedule.employer_id = employer.employer_id
JOIN schedule ON schedule.schedule_id = employer_schedule.schedule_id;

SELECT * FROM student
JOIN student_employer_rank_all ON student_employer_rank_all.student_id = student.student_id
JOIN employer ON employer.employer_id = student_employer_rank_all.employer_id
JOIN employer_schedule ON employer_schedule.employer_id = employer.employer_id
JOIN schedule ON schedule.schedule_id = employer_schedule.schedule_id;

SELECT *
FROM schedule