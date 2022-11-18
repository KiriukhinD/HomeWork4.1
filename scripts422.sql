select student.name, faculty.name_faculty
from student,
     faculty
where name_student_id = faculty.id;