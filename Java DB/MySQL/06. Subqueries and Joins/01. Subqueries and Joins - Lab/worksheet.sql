/* 1.	Managers
Write a query to retrieve information about the managers – id, full_name, deparment_id and department_name. 
Select the first 5 deparments ordered by employee_id. */

SELECT e.employee_id,
concat_ws(' ', first_name, last_name) as full_name,
d.department_id,
d.`name` as department_name
FROM employees as e
JOIN departments as d
ON d.manager_id = e.employee_id
ORDER BY e.employee_id
LIMIT 5;

/* 2.	Towns Adresses
Write a query to get information about the adresses in the database, which are in San Francisco, Sofia or Carnation. 
Retrieve town_id, town_name, address_text. Order the result by town_id, then by address_id. */

SELECT t.town_id, t.`name` as town_name, a.address_text
FROM towns as t
LEFT JOIN addresses as a
ON t.town_id = a.town_id
WHERE t.`name` IN ('San Francisco', 'Sofia', 'Carnation')
ORDER BY t.town_id, a.address_id;

/* 3.	Employees Without Managers
Write a query to get information about employee_id, 
first_name, last_name, department_id and salary for all employees who don’t have a manager. */

SELECT employee_id, first_name, last_name, department_id, salary
FROM employees
WHERE manager_id IS NULL;

/* 4.	Higher Salary
Write a query to count the number of employees who receive salary higher than the average. */

SELECT count(*) as 'count'
FROM employees
WHERE salary > (
	SELECT AVG(salary) FROM employees
);