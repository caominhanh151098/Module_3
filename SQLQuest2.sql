SELECT s.address, COUNT(1)
FROM student s
GROUP BY s.address;

SELECT s.student_id, s.student_name, AVG(m.mark)
FROM student s JOIN mark m ON s.student_id = m.student_id
GROUP BY s.student_name, m.mark_id;

SELECT s.student_id, s.student_name, AVG(m.mark)
FROM student s JOIN mark m ON s.student_id = m.student_id
GROUP BY s.student_name, m.mark_id
HAVING AVG(m.mark) > 15;

SELECT s.student_id, s.student_name, AVG(m.mark)
FROM student s JOIN mark m ON s.student_id = m.student_id
GROUP BY s.student_id
HAVING AVG(m.mark) >= ALL (SELECT AVG(m.mark) FROM mark m GROUP BY  m.student_id);