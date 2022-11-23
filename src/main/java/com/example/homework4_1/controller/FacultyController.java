package com.example.homework4_1.controller;


import com.example.homework4_1.model.Faculty;
import com.example.homework4_1.model.Student;
import com.example.homework4_1.service.FacultyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/faculty")
public class FacultyController {
    public final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }


    @PostMapping
    public Faculty create(@RequestBody Faculty faculty) {
        return facultyService.create(faculty);
    }

    @GetMapping("{id}")
    public Faculty read(@PathVariable long id) {
        return facultyService.read(id);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Faculty> update(@RequestBody Faculty faculty) {
        Faculty faculty1 = facultyService.update(faculty);
        if (faculty1 == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty1);

    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable long id) {
        facultyService.delete(id);

    }


    @GetMapping("/nameOrColor")
    public Collection<Faculty> findByNameOrColor(@RequestParam(required = false) String name,
                                                 @RequestParam(required = false) String color) {
        return facultyService.findByNameOrColor(name, color);
    }

    @GetMapping("/all")
    public Collection<Faculty> getAll() {
        return facultyService.getAll();
    }

    @GetMapping("/facultyStudent")
    public Collection<Student> getFacultyStudent(long id) {
        return facultyService.getFacultyStudent(id);
    }

    @GetMapping("/nameLongFaculty")
    public String nameLongFaculty() {
        return facultyService.nameLongFaculty();
    }
}
