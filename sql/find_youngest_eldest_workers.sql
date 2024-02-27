SELECT 'YOUNGEST' AS TYPE, NAME, BIRTHDAY
FROM worker
WHERE birthday IN(
      Select MAX(birthday)
      FROM worker)
UNION
SELECT 'OLDEST' AS TYPE, NAME, BIRTHDAY
FROM worker
WHERE birthday IN(
      Select MIN(birthday)
      FROM worker)