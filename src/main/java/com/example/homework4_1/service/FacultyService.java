package com.example.homework4_1.service;

import com.example.homework4_1.model.Faculty;
import com.example.homework4_1.model.Student;
import com.example.homework4_1.repository.FacultyRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;


@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;
    private final WeatherService weatherService;

    public FacultyService(FacultyRepository facultyRepository, WeatherService weatherService) {
        this.facultyRepository = facultyRepository;
        this.weatherService = weatherService;
    }

    public Faculty create(Faculty faculty) {
        weatherService.logger.info("method [create]");
        return facultyRepository.save(faculty);
    }

    public Faculty read(long id) {
        weatherService.logger.info("method [read]");
        return facultyRepository.findById(id).get();
    }

    public Faculty update(Faculty faculty) {
        weatherService.logger.info("method [update]");
        return facultyRepository.save(faculty);
    }

    public ResponseEntity<Faculty> delete(long id) {
        weatherService.logger.info("method [delete]");
        facultyRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }


    public Collection<Faculty> findByNameOrColor(String name, String color) {
        weatherService.logger.info("metod [findByNameOrColor]");
        return facultyRepository.findByNameFacultyIgnoreCaseOrColorIgnoreCase(name, color);
    }

    public Collection<Faculty> getAll() {
        weatherService.logger.info("method [getAll]");
        return facultyRepository.findAll();
    }

    public Collection<Student> getFacultyStudent(long id) {
        weatherService.logger.info("method [getFacultyStudent]");
        return facultyRepository.findByStudentsId(id);
    }

    public String nameLongFaculty() {
        return facultyRepository.findAll()
                .stream()
                .map(Faculty::getNameFaculty)
                .max(Comparator.comparingInt(String::length))
                .orElseThrow(RuntimeException::new);
    }
}
