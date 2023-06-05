select 	* from student
where student_name like 'h%';

select * from class
where month(start_date) = 12;

select * from subject
where credit between 3 and 5;

update student set class_id = 2
where student_name = 'Hung';

select Student_Name, Sub_Name, Mark
from mark join student on student.student_id = mark.student_id
			join subject on mark.sub_id = subject.sub_id
group by  Student_Name, Sub_Name, Mark
order by mark DESC;