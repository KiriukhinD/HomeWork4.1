package com.example.homework4_1.service;

import com.example.homework4_1.model.Faculty;
import com.example.homework4_1.model.Student;
import com.example.homework4_1.repository.FacultyRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty create(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty read(long id) {
        return facultyRepository.findById(id).get();
    }

    public Faculty update(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public ResponseEntity<Faculty> delete(long id) {
        facultyRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }


    public Collection<Faculty> findByNameOrColor(String name, String color) {
        return facultyRepository.findByNameFacultyIgnoreCaseOrColorIgnoreCase(name, color);
    }

    public Collection<Faculty> getAll() {
        return facultyRepository.findAll();
    }

    public Collection<Student> getFacultyStudent(long id) {
        return facultyRepository.findByStudentsId(id);
    }
}
