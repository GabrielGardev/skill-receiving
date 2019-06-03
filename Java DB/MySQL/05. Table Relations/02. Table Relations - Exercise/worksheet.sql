/* 1.	One-To-One Relationship
Create two tables as follows. Use appropriate data types.
•	Alter table persons and make person_id a primary key. 
•	Create a foreign key between persons and passports by using the passport_id column. 
•	Think about which passport field should be UNIQUE. */

CREATE TABLE passports(
passport_id INT PRIMARY KEY AUTO_INCREMENT,
passport_number VARCHAR(8) UNIQUE
) AUTO_INCREMENT = 101;

CREATE TABLE persons(
person_id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(20),
salary DECIMAL(14, 2),
passport_id INT UNIQUE NOT NULL
);

INSERT INTO persons (first_name, salary, passport_id) 
	VALUES 
		('Roberto', 43300, 102), 
		('Tom', 56100, 103), 
		('Yana', 60200, 101);

INSERT  INTO passports (passport_number) 
    VALUES ('N34FG21B'), ('K65LO4R7'), ('ZE657QP2');

ALTER TABLE persons 
ADD CONSTRAINT fk_persons_passports FOREIGN KEY (passport_id) REFERENCES passports(passport_id);

/* 2.	One-To-Many Relationship
Create two tables as follows. Use appropriate data types.
Insert the data from the example above. 
•	Add primary and foreign keys. */

CREATE TABLE manufacturers (
    manufacturer_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL,
    established_on DATE NOT NULL
);

CREATE TABLE models (
    model_id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(30) NOT NULL,
    manufacturer_id INT,
    CONSTRAINT fk_models_manufacturers FOREIGN KEY (manufacturer_id)
        REFERENCES manufacturers (manufacturer_id)
)  AUTO_INCREMENT=101;

INSERT 
	INTO manufacturers (name, established_on)
	VALUES 
		('BMW', '1916-03-01'),
		('Tesla', '2003-01-01'),
		('Lada', '1966-05-01');

INSERT
	INTO models (name, manufacturer_id)
    VALUES
		('X1', 1),
		('i6', 1),
		('Model S', 2),
		('Model X', 2),
		('Model 3', 2),
		('Nova', 3);
        
/* 3.	Many-To-Many Relationship
Create three tables as follows. Use appropriate data types.
•	Add primary and foreign keys.
•	Have in mind that the table student_exams should have a composite primary key. */

CREATE TABLE students(
student_id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL
);

CREATE TABLE exams (
exam_id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL
)  AUTO_INCREMENT = 101;

CREATE TABLE students_exams(
student_id INT NOT NULL,
exam_id INT NOT NULL,
CONSTRAINT pk_studentsExams PRIMARY KEY (student_id, exam_id),
CONSTRAINT fk_studentsExams_students FOREIGN KEY (student_id) REFERENCES students(student_id),
CONSTRAINT fk_studentsExams_exams FOREIGN KEY (exam_id) REFERENCES exams(exam_id)
);

INSERT 
	INTO students 
		(name)
	VALUES 
		('Mila'), 
        ('Toni'), 
        ('Ron');

INSERT 
	INTO exams 
		(name)
	VALUES 
		('Spring MVC'), 
        ('Neo4j'), 
        ('Oracle 11g');

INSERT 
	INTO students_exams
    VALUES  
		(1, 101),
		(1, 102),
		(2, 101),
		(3, 103),
		(2, 102),
		(2, 103);
        
/* 4.	Self-Referencing
Create a single table as follows. Use appropriate data types.
•	Add primary and foreign keys. 
•	The foreign key should be between manager_id and teacher_id. */

CREATE TABLE teachers (
teacher_id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(30) NOT NULL,
manager_id INT
)  AUTO_INCREMENT=101;


INSERT 
	INTO teachers
		(`name`, manager_id)
    VALUES
		('John', NULL),
        ('Maya', 106),
        ('Silvia', 106),
        ('Ted', 105),
        ('Mark', 101),
        ('Greta', 101);

ALTER TABLE teachers
ADD CONSTRAINT fk_manager_teacher_id FOREIGN KEY (manager_id) REFERENCES teachers(teacher_id);

/* 5. Online Store Database */

CREATE DATABASE online_store;

USE online_store;

CREATE TABLE cities (
city_id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50)
);

CREATE TABLE item_types (
item_type_id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50)
);

CREATE TABLE customers (
customer_id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50),
birthday DATE,
city_id INT,
CONSTRAINT fk_customers_cities FOREIGN KEY (city_id) REFERENCES cities (city_id)
);

CREATE TABLE orders (
order_id INT PRIMARY KEY AUTO_INCREMENT,
customer_id INT,
CONSTRAINT fk_orders_customers FOREIGN KEY (customer_id) REFERENCES customers (customer_id)
);

CREATE TABLE items (
item_id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50),
item_type_id INT,
CONSTRAINT fk_item_types_items FOREIGN KEY (item_type_id) REFERENCES item_types (item_type_id)
);

CREATE TABLE order_items (
order_id INT NOT NULL,
item_id INT NOT NULL,
CONSTRAINT PRIMARY KEY (order_id , item_id),
CONSTRAINT fk_orders_order_items FOREIGN KEY (order_id) REFERENCES orders (order_id),
CONSTRAINT fk_items_order_items FOREIGN KEY (item_id) REFERENCES items (item_id)
);


/* 6. University Database */

CREATE DATABASE university;

USE university;

CREATE TABLE subjects (
subject_id INT PRIMARY KEY AUTO_INCREMENT,
subject_name VARCHAR(50)
);

CREATE TABLE majors (
major_id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50) 
);

CREATE TABLE students (
student_id INT PRIMARY KEY AUTO_INCREMENT,
student_number VARCHAR(12),
student_name VARCHAR(50),
major_id INT,
CONSTRAINT fk_majors_students FOREIGN KEY (major_id) REFERENCES majors (major_id)
);

CREATE TABLE payments (
payment_id INT PRIMARY KEY AUTO_INCREMENT,
payment_date DATE,
payment_amount DECIMAL(8,2),
student_id INT,
CONSTRAINT fk_students_payments FOREIGN KEY (student_id) REFERENCES students (student_id)
);

CREATE TABLE agenda (
student_id INT NOT NULL,
subject_id INT NOT NULL,
CONSTRAINT PRIMARY KEY (student_id , subject_id),
CONSTRAINT fk_students_agenda FOREIGN KEY (student_id) REFERENCES students (student_id),
CONSTRAINT fk_subjects_agenda FOREIGN KEY (subject_id) REFERENCES subjects (subject_id)
);

/* 9.	Peaks in Rila
Display all peaks for "Rila" mountain_range. Include:
•	mountain_range
•	peak_name
•	peak_elevation
Peaks should be sorted by peak_elevation descending. */

USE geography;

SELECT m.mountain_range, p.peak_name, p.elevation AS peak_elevation
FROM mountains AS m
JOIN
    peaks AS p ON m.id = p.mountain_id
WHERE
    m.mountain_range = 'Rila'
ORDER BY peak_elevation DESC; 