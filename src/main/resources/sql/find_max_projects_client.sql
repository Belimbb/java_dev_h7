SELECT p.*, subquery.freq
FROM project p
JOIN (
    SELECT client_id, COUNT(*) as freq
    FROM project
    GROUP BY client_id
) AS subquery ON p.client_id = subquery.client_id
WHERE subquery.freq = (
    SELECT MAX(freq) FROM (
        SELECT client_id, COUNT(*) as freq
        FROM project
        GROUP BY client_id
    ) AS subquery
);