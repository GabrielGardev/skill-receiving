/* Select Employee Information
Write a query to select all employees and retrieve information about their id, first_name, last_name and job_title ordered by id. */

USE hospital;

SELECT id, first_name, last_name, job_title
FROM employees
ORDER BY id;

/* Select Employees with Filter
Write a query to select all employees (id, first_name, last_name, job_title, salary)
whose salaries are higher than 1000.00, ordered by id. 
Concatenate fields first_name and last_name into ‘full_name’. */

SELECT id, concat(`first_name`, ' ', `last_name`) as `full_name`, job_title, salary
FROM employees
WHERE salary > 1000
ORDER BY id;

/* Update Employees Salary
Update all employees salaries whose job_title is “Therapist” by 10%. Retrieve information about all salaries ordered ascending. */

UPDATE employees 
SET salary = salary * 1.1
WHERE job_title = 'Therapist';

SELECT salary FROM employees
ORDER BY salary ASC;

/* Top Paid Employee
Write a query to create a view that selects all information about 
the top paid employee from the “employees” table in the hospital database. */

SELECT * FROM employees
ORDER BY salary DESC
LIMIT 1;

/* Select Employees by Multiple Filters
Write a query to retrieve information about employees, who are in department 4 and have salary higher or equal to 1600.
Order the information by id. */

SELECT * FROM employees
WHERE department_id = 4 AND salary >= 1600
ORDER BY id;

/* Delete from Table
Write a query to delete all employees from the “employees” table who are in department 2 or 1. 
Order the information by id. */

DELETE FROM employees
WHERE department_id IN (1,2);

SELECT * FROM employees
ORDER BY id;
