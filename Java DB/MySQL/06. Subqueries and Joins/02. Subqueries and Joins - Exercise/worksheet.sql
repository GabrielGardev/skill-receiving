/* 1.	Employee Address
Write a query that selects:
•	employee_id
•	job_title
•	address_id
•	address_text
Return the first 5 rows sorted by address_id in ascending order. */

USE soft_uni;

SELECT e.employee_id, e.job_title, a.address_id, a.address_text
FROM employees as e
JOIN addresses as a
ON e.address_id = a.address_id
ORDER BY address_id
LIMIT 5;

/* 2.	Addresses with Towns
Write a query that selects:
•	first_name
•	last_name
•	town
•	address_text
Sort the result by first_name in ascending order then by last_name. Select first 5 employees. */

SELECT e.first_name, e.last_name, t.`name`, a.address_text
FROM employees as e
JOIN addresses as a
ON a.address_id = e.address_id
JOIN towns as t
ON t.town_id = a.town_id
ORDER BY first_name, last_name
LIMIT 5;

/* 3.	Sales Employee
Write a query that selects:
•	employee_id
•	first_name
•	last_name
•	department_name
Sort the result by employee_id in descending order. Select only employees from the “Sales” department. */

SELECT e.employee_id, e.first_name, e.last_name, d.`name` as 'department_name'
FROM employees as e
JOIN departments as d
ON e.department_id = d.department_id
WHERE d.`name` LIKE 'Sales'
ORDER BY e.employee_id DESC;

/* 4.	Employee Departments
Write a query that selects:
•	employee_id
•	first_name
•	salary
•	department_name
Filter only employees with salary higher than 15000. Return the first 5 rows sorted by department_id in descending order. */

SELECT e.employee_id, e.first_name, e.salary, d.`name` as 'department_name'
FROM employees as e
JOIN departments as d
ON e.department_id = d.department_id
WHERE e.salary > 15000
ORDER BY d.department_id DESC
LIMIT 5;

/* 5.	Employees Without Project
Write a query that selects:
•	employee_id
•	first_name
Filter only employees without a project. Return the first 3 rows sorted by employee_id in descending order. */

SELECT e1.employee_id, e1.first_name
FROM employees as e1
LEFT JOIN employees_projects as e2
ON e1.employee_id = e2.employee_id
WHERE isnull(e2.employee_id)
ORDER BY e1.employee_id DESC
LIMIT 3;

/* 6.	Employees Hired After
Write a query that selects:
•	first_name
•	last_name
•	hire_date
•	dept_name
Filter only employees hired after 1/1/1999 and from either the "Sales" or the "Finance" departments. 
Sort the result by hire_date (ascending). */

SELECT e.first_name, e.last_name, e.hire_date, d.`name` as dept_name 
FROM employees as e
JOIN departments as d
ON e.department_id = d.department_id
WHERE DATE(e.hire_date) > '1999-01-01' AND d.`name` IN('Sales', 'Finance')
ORDER BY e.hire_date ASC;

/* 7.	Employees with Project
Write a query that selects:
•	employee_id
•	first_name
•	project_name
Filter only employees with a project, which has started after 13.08.2002 and it is still ongoing (no end date). 
Return the first 5 rows sorted by first_name then by project_name both  in ascending order. */

SELECT e1.employee_id, e1.first_name, p.`name` as project_name
FROM employees as e1
JOIN employees_projects as e2
ON e1.employee_id = e2.employee_id
JOIN projects as p
ON e2.project_id = p.project_id
WHERE DATE(p.start_date) > '2002-08-13' AND DATE(p.end_date) IS NULL
ORDER BY e1.first_name, p.`name`
LIMIT 5;

/* 8.	Employee 24
Write a query that selects:
•	employee_id
•	first_name
•	project_name
Filter all the projects of employees with id 24. 
If the project has started after 2005 inclusively the return value should be NULL. 
Sort the result by project_name alphabetically. */

SELECT e1.employee_id, e1.first_name, 
IF(YEAR(p.start_date) >= 2005,
        NULL,
        p.`name`) as project_name
FROM employees as e1
JOIN employees_projects as e2
ON e1.employee_id = e2.employee_id
JOIN projects as p
ON e2.project_id = p.project_id
WHERE e2.employee_id = 24
ORDER BY p.`name` ASC;

/* 9.	Employee Manager
Write a query that selects:
•	employee_id
•	first_name
•	manager_id
•	manager_name
Filter all employees with a manager who has id equal to 3 or 7. 
Return all rows sorted by employee first_name in ascending order. */

SELECT e1.employee_id, e1.first_name, e2.employee_id, e2.first_name as 'manager_name'
FROM employees as e1
JOIN employees as e2
ON e2.employee_id = e1.manager_id
WHERE e1.manager_id IN (3,7)
ORDER BY e1.first_name;

/* 10.	Employee Summary
Write a query that selects:
•	employee_id
•	employee_name
•	manager_name
•	department_name
Show the first 5 employees (only for employees who have a manager) with their managers 
and the departments they are in (show the departments of the employees). Order by employee_id. */

SELECT e.employee_id,
concat_ws(' ',e.first_name, e.last_name) as employee_name,
concat_ws(' ', e1.first_name, e1.last_name) as manager_name,
d.`name` as department_name
FROM employees as e
JOIN employees as e1
ON e1.employee_id = e.manager_id
JOIN departments as d
ON e.department_id = d.department_id
WHERE e.manager_id IS NOT NULL
ORDER BY e.employee_id
LIMIT 5;

/* 11.	Min Average Salary
Write a query that returns the value of the lowest average salary of all departments. */

SELECT MIN(min_average_salary) as min_average_salary
FROM
(
	SELECT AVG(e.salary) as 'min_average_salary' FROM employees AS e
    GROUP BY e.department_id
) as e1;

/* 12.	Highest Peaks in Bulgaria
Write a query that selects:
•	country_code	
•	mountain_range
•	peak_name
•	elevation
Filter all peaks in Bulgaria with elevation over 2835. Return all rows sorted by elevation in descending order. */

SELECT mc.country_code, m.mountain_range, p.peak_name, p.elevation
FROM mountains_countries as mc
JOIN mountains as m
ON mc.mountain_id = m.id
JOIN peaks as p
ON m.id = p.mountain_id
WHERE mc.country_code LIKE 'BG' AND p.elevation > 2835
ORDER BY p.elevation DESC;

/* 13.	Count Mountain Ranges
Write a query that selects:
•	country_code
•	mountain_range
Filter the count of the mountain ranges in the United States, Russia and Bulgaria. 
Sort result by mountain_range count in decreasing order. */

SELECT mc.country_code, COUNT(m.mountain_range) as 'mountain_range'
FROM mountains_countries as mc
JOIN mountains as m
ON mc.mountain_id = m.id
WHERE mc.country_code IN ('US', 'BG', 'RU')
GROUP BY mc.country_code
ORDER BY `mountain_range` DESC;

/* 14.	Countries with Rivers
Write a query that selects:
•	country_name
•	river_name
Find the first 5 countries with or without rivers in Africa. Sort them by country_name in ascending order. */

SELECT c.country_name, r.river_name
FROM countries as c
LEFT JOIN countries_rivers as cr
ON c.country_code = cr.country_code
LEFT JOIN rivers as r
ON cr.river_id = r.id
WHERE c.continent_code LIKE 'AF'
ORDER BY c.country_name ASC
LIMIT 5;

/* 15.	*Continents and Currencies
Write a query that selects:
•	continent_code
•	currency_code
•	currency_usage
Find all continents and their most used currency. Filter any currency that is used in only one country. 
Sort the result by continent_code and currency_code. */

SELECT d1.continent_code, d1.currency_code, d1.currency_usage FROM
    (SELECT c.continent_code, c.currency_code,
    COUNT(c.currency_code) AS 'currency_usage' FROM countries as c
    GROUP BY c.currency_code, c.continent_code HAVING currency_usage > 1) as d1
LEFT JOIN
    (SELECT c.continent_code, c.currency_code,
    COUNT(c.currency_code) AS 'currency_usage' FROM countries as c
     GROUP BY c.currency_code, c.continent_code HAVING currency_usage > 1) as d2
ON d1.continent_code = d2.continent_code AND d2.currency_usage > d1.currency_usage
WHERE d2.currency_usage IS NULL
ORDER BY d1.continent_code, d1.currency_code;

/* 16.	Countries without any Mountains
Find the count of all countries which don’t have a mountain. */

SELECT (COUNT(*) - COUNT(mc.mountain_id)) as country_count
FROM countries as c
LEFT JOIN mountains_countries as mc
ON c.country_code = mc.country_code;

/* 17.	Highest Peak and Longest River by Country
For each country, find the elevation of the highest peak and the length of the longest river, 
sorted by the highest peak_elevation (from highest to lowest), 
then by the longest river_length (from longest to smallest), then by country_name (alphabetically). 
Display NULL when no data is available in some of the columns. Limit only the first 5 rows. */

SELECT c.country_name, 
		MAX(p.elevation) as 'highest_peak_elevation', 
		MAX(r.length) as 'longest_river_length'
FROM countries as c
LEFT JOIN mountains_countries as mc
ON c.country_code = mc.country_code
LEFT JOIN peaks as p
ON mc.mountain_id = p.mountain_id
LEFT JOIN countries_rivers as cr
ON c.country_code = cr.country_code
LEFT JOIN rivers as r
ON cr.river_id = r.id
GROUP BY c.country_name
ORDER BY `highest_peak_elevation` DESC, `longest_river_length` DESC, c.country_name
LIMIT 5;