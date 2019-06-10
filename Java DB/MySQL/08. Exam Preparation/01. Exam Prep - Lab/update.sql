SET SQL_SAFE_UPDATES = 0;

UPDATE repositories_contributors as rc
SET rc.repository_id = 

(SELECT r.id FROM repositories as r
 WHERE r.id NOT IN (SELECT repository_id FROM (
 SELECT repository_id FROM repositories_contributors) as a)
 ORDER BY r.id LIMIT 1)
 
WHERE rc.repository_id = rc.contributor_id;