/* 1.	 Mountains and Peaks
Write a query to create two tables – mountains and peaks and link their fields properly. Tables should have:
-	Mountains:
•	id 
•	name
-	Peaks: 
•	id
•	name
•	mountain_id */
USE camp;

CREATE TABLE mountains (
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL);

CREATE TABLE peaks(
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL,
mountain_id INT NOT NULL,
CONSTRAINT  fk_peaks_mountains FOREIGN KEY (mountain_id) REFERENCES mountains(id));

/* 2.	 Trip Organization
Write a query to retrieve information about SoftUni camp’s transportation organization. 
Get information about the drivers (name and id) and their vehicle type. */

SELECT driver_id, vehicle_type, concat(first_name, ' ', last_name) AS driver_name
FROM vehicles AS v
JOIN campers AS c
ON v.driver_id = c.id;

/* 3.	SoftUni Hiking
Get information about the hiking routes – starting point and ending point, and their leaders – name and id. */

SELECT starting_point as route_starting_point, 
end_point as route_ending_point, leader_id, 
concat(first_name, ' ', last_name) as leader_name
FROM routes as r
JOIN campers as c
ON r.leader_id = c.id;

/* 4.	Delete Mountains
Drop tables from the task 1.
Write a query to create a one-to-many relationship between a table, 
holding information about peaks (id, name) and other - about mountains (id, name, mountain_id), 
so that when an mountains gets removed from the database, all of his peaks are deleted too. */

ALTER TABLE `camp`.`peaks` 
DROP FOREIGN KEY `fk_peaks_mountains`;
ALTER TABLE `camp`.`peaks` 
DROP INDEX `fk_peaks_mountains` ;

DROP TABLE mountains;
DROP TABLE peaks;

CREATE TABLE mountains (
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL);

CREATE TABLE peaks(
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL,
mountain_id INT,
CONSTRAINT  fk_peaks_mountains FOREIGN KEY (mountain_id) REFERENCES mountains(id)
ON DELETE CASCADE);

/* 5.	 Project Management DB* */

CREATE DATABASE management_db;

USE management_db;

CREATE TABLE employees(
id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(30),
last_name VARCHAR(30),
project_id INT
);

CREATE TABLE projects(
id INT PRIMARY KEY AUTO_INCREMENT,
client_id INT,
project_lead_id INT
);

CREATE TABLE clients(
id INT PRIMARY KEY AUTO_INCREMENT,
client_name VARCHAR(100),
project_id INT,
CONSTRAINT fk_clients_projects FOREIGN KEY (project_id) REFERENCES projects(id));

ALTER TABLE employees
ADD CONSTRAINT fk_employees_projects FOREIGN KEY (project_id) REFERENCES projects (id);
 
ALTER TABLE projects 
	ADD CONSTRAINT fk_projects_clients FOREIGN KEY (client_id) REFERENCES clients(id),
    ADD CONSTRAINT fk_projects_employees FOREIGN KEY (project_lead_id) REFERENCES employees(id);