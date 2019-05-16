/* Write a query that will create the “gamebar” database. */

CREATE DATABASE gamebar;

USE gamebar;

/* Create Tables */

CREATE TABLE employees(
id INT(11) PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(50) NOT NULL,
last_name VARCHAR(50) NOT NULL
);
 
CREATE TABLE categories(
id INT(11) PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(50) NOT NULL
);
 
CREATE TABLE products(
id INT(11) PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(50) NOT NULL,
category_id INT(11) NOT NULL
);

/* Insert Data in Tables */

INSERT INTO employees (first_name, last_name) VALUES ('Pesho', 'Peshev');
INSERT INTO employees (first_name, last_name) VALUES ('Gosho', 'Goshev');
INSERT INTO employees (first_name, last_name) VALUES ('Martin', 'Martinev');

/* Alter Tables */

ALTER TABLE employees
ADD COLUMN middle_name VARCHAR(50) NOT NULL AFTER last_name;

/* Adding Constraints
Create the connection via foreign key between the “products” and “categories” tables that you’ve created earlier. 
Make “category_id” foreign key linked to “id” in the “categories” table. */

ALTER TABLE products 
ADD CONSTRAINT my_fk
  FOREIGN KEY (category_id)
  REFERENCES categories (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
/* Modifying Columns
Change the property “VARCHAR(50)” to “VARCHAR(100)” to the “middle_name” column in “employees” table. */

ALTER TABLE employees 
CHANGE COLUMN middle_name middle_name VARCHAR(100) NOT NULL ;

/* Drop the “gamebar” database. */

DROP DATABASE gamebar;