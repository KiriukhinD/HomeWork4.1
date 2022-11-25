package com.example.homework4_1.repository;

import com.example.homework4_1.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Collection<Student> findAllByAge(int age);

    @Query(value = "select COUNT(id ) from  student", nativeQuery = true)
    int findByStudentId();

    @Query(value = "select * from student ORDER BY id DESC Limit 5 ", nativeQuery = true)
    Collection<Student> studentFive();

    @Query(value = "select AVG(age) from  student", nativeQuery = true)
    Optional<Double> average();

}
