SELECT *
FROM subject s
WHERE s.credit >=(SELECT MAX(s.credit) FROM subject s);

SELECT s.sub_id, s.sub_name, m.mark
FROM mark m JOIN subject s ON m.sub_id = s.sub_id
WHERE m.mark >= (SELECT MAX(m.mark) FROM mark m);

SELECT s.student_id, s.student_name, AVG(m.mark)
FROM student s LEFT JOIN mark m ON s.student_id = m.student_id
				LEFT JOIN subject sb ON m.sub_id = sb.sub_id
GROUP BY s.student_id
ORDER BY AVG(m.mark) DESC;
