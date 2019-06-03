/* 1.	Find Book Titles
Write a SQL query to find books which titles start with “The”. Order the result by id. */

USE book_library;

SELECT title FROM books
WHERE SUBSTRING(title, 1, 3) = 'The'
ORDER BY id;

/* 2.	Replace Titles
Write a SQL query to find books which titles start with “The” and replace the substring with 3 asterisks. 
Retrieve data about the updated titles. Order the result by id. */

SELECT REPLACE(title, 'The', '***') FROM books
WHERE SUBSTRING(title, 1, 3) = 'The'
ORDER BY id;

/* 3.	Sum Cost of All Books
Write a SQL query to sum prices of all books. Format the output to 2 digits after decimal point. */

SELECT FORMAT(SUM(cost), 2) FROM books;

/* 4.	Days Lived
Write a SQL query to calculate the days that the authors have lived. NULL values mean that the author is still alive. */

SELECT concat(first_name, ' ', last_name) AS 'Full Name',
DATEDIFF(died, born) AS 'Days Lived' 
FROM authors;

/* 5.	Harry Potter Books
Write a SQL query to retrieve titles of all the Harry Potter books. Order the information by id. */

SELECT title FROM books
WHERE SUBSTRING(title, 1, 12) = 'Harry Potter'
ORDER BY id;