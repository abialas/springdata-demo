INSERT INTO employee(id, end_date, first_name, last_name, position, start_date, experience_level, salary, "user")
VALUES (1,  null, 'Adam', 'Bialas', 'DEVELOPER', null, 'SENIOR', 1500.0, 'abialas');

INSERT INTO task(id, name, time_create)
VALUES (1, 'Code Review', '2017-01-01');

INSERT INTO task_employees(tasks_id, employees_id)
VALUES (1, 1);

INSERT INTO task(id, name, time_create)
VALUES (2, 'Code Review', '2017-02-01');

INSERT INTO task_employees(tasks_id, employees_id)
VALUES (2, 1);

INSERT INTO task(id, name, time_create)
VALUES (3, 'New feature', '2017-03-01');

INSERT INTO task_employees(tasks_id, employees_id)
VALUES (3, 1);