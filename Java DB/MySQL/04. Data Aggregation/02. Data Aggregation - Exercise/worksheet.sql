/* 1. Records’ Count
Import the database and send the total count of records to Mr. Bodrog. Make sure nothing got lost. */

USE gringotts;

SELECT COUNT(id) AS 'count'
FROM wizzard_deposits;

/* 2. Longest Magic Wand
Select the size of the longest magic wand. Rename the new column appropriately. */

SELECT MAX(magic_wand_size) as 'longest_magic_wand'
FROM wizzard_deposits;

/* 3. Longest Magic Wand per Deposit Groups
For wizards in each deposit group show the longest magic wand. 
Sort result by longest magic wand for each deposit group in increasing order, then by deposit_group alphabetically. 
Rename the new column appropriately. */

SELECT deposit_group, MAX(magic_wand_size) as 'longest_magic_wand'
FROM wizzard_deposits
GROUP BY deposit_group
ORDER BY `longest_magic_wand`, deposit_group;

/* 4. Smallest Deposit Group per Magic Wand Size*
Select the deposit group with the lowest average wand size. */

SELECT deposit_group 
FROM wizzard_deposits
GROUP BY deposit_group
ORDER BY AVG(magic_wand_size)
LIMIT 1;

/* 5. Deposits Sum
Select all deposit groups and its total deposit sum. Sort result by total_sum in increasing order. */

SELECT deposit_group, SUM(deposit_amount) as 'total_sum'
FROM wizzard_deposits
GROUP BY deposit_group
ORDER BY `total_sum`;

/* 6. Deposits Sum for Ollivander family
Select all deposit groups and its total deposit sum but only for the wizards who has their magic wand crafted by Ollivander family. 
Sort result by deposit_group alphabetically. */

SELECT deposit_group, SUM(deposit_amount) as 'total_sum'
FROM wizzard_deposits
WHERE magic_wand_creator = 'Ollivander family'
GROUP BY deposit_group
ORDER BY deposit_group;

/* 7. Deposits Filter
Select all deposit groups and its total deposit sum but only for the wizards who has their magic wand crafted by Ollivander family. 
After this, filter total deposit sums lower than 150000. Order by total deposit sum in descending order. */

SELECT deposit_group, SUM(deposit_amount) as 'total_sum'
FROM wizzard_deposits
WHERE magic_wand_creator = 'Ollivander family'
GROUP BY deposit_group
HAVING `total_sum` < 150000
ORDER BY `total_sum` DESC;

/* 8. Deposit charge
Create a query that selects:
•	Deposit group 
•	Magic wand creator
•	Minimum deposit charge for each group 
Group by deposit_group and magic_wand_creator.
Select the data in ascending order by magic_wand_creator and deposit_group. */

SELECT deposit_group, magic_wand_creator, MIN(deposit_charge) as 'min_deposti_charge'
FROM wizzard_deposits
GROUP BY deposit_group, magic_wand_creator
ORDER BY magic_wand_creator, deposit_group;

/* 9. Age Groups
Write down a query that creates 7 different groups based on their age.
Age groups should be as follows:
•	[0-10]
•	[11-20]
•	[21-30]
•	[31-40]
•	[41-50]
•	[51-60]
•	[61+]
The query should return:
•	Age groups
•	Count of wizards in it
Sort result by increasing size of age groups. */

SELECT 
	CASE
		WHEN age >= 0 AND age <= 10 THEN '[0-10]'
        WHEN age >= 11 AND age <= 20 THEN '[11-20]'
        WHEN age >= 21 AND age <= 30 THEN '[21-30]'
        WHEN age >= 31 AND age <= 40 THEN '[31-40]'
        WHEN age >= 41 AND age <= 50 THEN '[41-50]'
        WHEN age >= 51 AND age <= 60 THEN '[51-60]'
        ELSE '[61+]'
	END as 'age_group',
    COUNT(id) as 'wizard_count'
FROM wizzard_deposits
GROUP BY `age_group`
ORDER BY `age_group`;
    
/* 10. First Letter
Write a query that returns all unique wizard first letters of their first names only if they have deposit of type Troll Chest. 
Order them alphabetically. Use GROUP BY for uniqueness. */

SELECT substring(first_name, 1, 1) as 'first_letter'
FROM wizzard_deposits
WHERE deposit_group = 'Troll Chest'
GROUP BY `first_letter`
ORDER BY `first_letter`;
        
/* 11.	Average Interest 
Mr. Bodrog is highly interested in profitability. 
He wants to know the average interest of all deposits groups split by whether the deposit has expired or not. 
But that’s not all. He wants you to select deposits with start date after 01/01/1985. 
Order the data descending by Deposit Group and ascending by Expiration Flag. */

SELECT deposit_group, is_deposit_expired, AVG(deposit_interest) as 'average_interest'
FROM wizzard_deposits
WHERE deposit_start_date > '1985-01-01'
GROUP BY deposit_group, is_deposit_expired
ORDER BY deposit_group DESC, is_deposit_expired;

/* 12.	Rich Wizard, Poor Wizard*
Give Mr. Bodrog some data to play his favorite game Rich Wizard, Poor Wizard. 
The rules are simple: You compare the deposits of every wizard with the wizard after him. 
If a wizard is the last one in the database, simply ignore it. 
At the end you have to sum the difference between the deposits. */

SELECT SUM(wd1.deposit_amount - wd2.deposit_amount) as 'sum_difference'
FROM wizzard_deposits as wd1,
	 wizzard_deposits as wd2
WHERE wd2.id - wd1.id = 1;

/* 13.	 Employees Minimum Salaries
That’s it! You no longer work for Mr. Bodrog. You have decided to find a proper job as an analyst in SoftUni. 
It’s not a surprise that you will use the soft_uni database. 
Select the minimum salary from the employees for departments with ID (2,5,7) but only for those who are hired after 01/01/2000. 
Sort result by department_id in ascending order.
Your query should return:
•	department_id */

USE soft_uni;

SELECT department_id, MIN(salary) as 'minimum_salary'
FROM employees
WHERE department_id in (2, 5 ,7) AND hire_date > 2000-01-01
GROUP BY department_id
ORDER BY department_id;

/* 14.	Employees Average Salaries
Select all high paid employees who earn more than 30000 into a new table. 
Then delete all high paid employees who have manager_id = 42 from the new table; 
Then increase the salaries of all high paid employees with department_id =1 with 5000 in the new table. 
Finally, select the average salaries in each department from the new table. Sort result by department_id in increasing order. */

SELECT department_id, 
		CASE
			WHEN department_id = 1 THEN AVG(salary) + 5000
            ELSE AVG(salary)
		END as 'avg_salary'
FROM employees
WHERE manager_id != 42 AND salary > 30000
GROUP BY department_id
ORDER BY department_id;

/* 15. Employees Maximum Salaries
Find the max salary for each department. 
Filter those which have max salaries not in the range 30000 and 70000. 
Sort result by department_id in increasing order. */

SELECT department_id, MAX(salary) as 'max_salary'
FROM employees
GROUP BY department_id
HAVING NOT (max_salary BETWEEN 30000 AND 70000)
ORDER BY department_id;

/* 16.	Employees Count Salaries
Count the salaries of all employees who don’t have a manager. */

SELECT count(salary)
FROM employees
WHERE manager_id IS NULL;

/* 17.	3rd Highest Salary*
Find the third highest salary in each department if there is such. 
Sort result by department_id in increasing order. */

SELECT department_id, 
		(SELECT DISTINCT
				e2.salary
                FROM employees as e2
                WHERE e2.department_id = e1.department_id
                ORDER BY e2.salary DESC
                LIMIT 2, 1) as `third_highest_salary`
FROM employees as e1
GROUP BY department_id
HAVING `third_highest_salary` IS NOT NULL;

/* 18.	 Salary Challenge**
Write a query that returns:
•	first_name
•	last_name
•	department_id
for all employees who have salary higher than the average salary of their respective departments. 
Select only the first 10 rows. Order by department_id. */

SELECT 
    e1.first_name, e1.last_name, e1.department_id
FROM
    employees AS e1
        JOIN
    (SELECT 
        e2.department_id, AVG(e2.salary) AS dep_avg_salary
    FROM
        employees AS e2
    GROUP BY e2.department_id) AS e3 ON e1.department_id = e3.department_id
WHERE
    e1.salary > e3.dep_avg_salary
ORDER BY department_id
LIMIT 10;

/* 19.	Departments Total Salaries
Create a query which shows the total sum of salaries for each department. Order by department_id.
Your query should return:	
•	department_id */

SELECT 
    e1.department_id, SUM(e1.salary)
FROM
    employees AS e1
GROUP BY e1.department_id
ORDER BY department_id;