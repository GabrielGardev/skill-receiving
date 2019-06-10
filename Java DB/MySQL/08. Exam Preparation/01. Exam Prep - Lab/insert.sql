INSERT INTO issues (title, issue_status, repository_id, assignee_id)
SELECT concat('Critical Problem With ', f.`name`, '!') as title,
		'open' as issue_status,
        CEIL((f.id * 2) / 3) as repository_id,
        (SELECT c.contributor_id FROM files as f1
        JOIN commits as c
        ON f1.commit_id = c.id
        WHERE f1.id = f.id) as assignee_id
FROM files as f
WHERE f.id BETWEEN 46 AND 50;



