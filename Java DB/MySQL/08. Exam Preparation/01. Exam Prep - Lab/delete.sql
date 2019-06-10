DELETE FROM repositories
WHERE id NOT IN(SELECT repository_id FROM issues);