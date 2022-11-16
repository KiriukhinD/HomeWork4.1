package com.example.homework4_1.repository;

import com.example.homework4_1.entity.StudentParam;
import com.example.homework4_1.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Collection<Student> findAllByAge(int age);

    @Query(value = "select COUNT(id ),AVG(age)from student ", nativeQuery = true)
    Collection<StudentParam> findByStudentId();

    @Query(value = "select * from student ORDER BY id DESC Limit 5 ", nativeQuery = true)
    Collection<Student> studentFive();
}
