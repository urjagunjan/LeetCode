# Write your MySQL query statement below
WITH RECURSIVE TreeInfo AS (
    -- Root nodes
    SELECT
        id,
        p_id,
        0 AS level
    FROM Tree
    WHERE p_id IS NULL

    UNION ALL

    -- Traverse children
    SELECT
        t.id,
        t.p_id,
        ti.level + 1
    FROM Tree t
    JOIN TreeInfo ti
        ON t.p_id = ti.id
)

SELECT
    ti.id,
    CASE
        WHEN ti.p_id IS NULL THEN 'Root'
        WHEN EXISTS (
            SELECT 1
            FROM Tree c
            WHERE c.p_id = ti.id
        ) THEN 'Inner'
        ELSE 'Leaf'
    END AS type
FROM TreeInfo ti
ORDER BY ti.id;