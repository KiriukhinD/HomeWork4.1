package com.example.homework4_1.repository;


import com.example.homework4_1.model.Faculty;
import com.example.homework4_1.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;


@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    Collection<Faculty> findByNameFacultyIgnoreCaseOrColorIgnoreCase(String name, String color);

    Collection<Student> findByStudentsId(long id);

}
