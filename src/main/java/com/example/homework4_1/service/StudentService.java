package com.example.homework4_1.service;

import com.example.homework4_1.model.Avatar;
import com.example.homework4_1.model.Student;
import com.example.homework4_1.repository.AvatarPaginAndSortRepository;
import com.example.homework4_1.repository.AvatarRepository;
import com.example.homework4_1.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.List;

import static java.nio.file.StandardOpenOption.CREATE_NEW;

@Service
@Transactional
public class StudentService {

    private final StudentRepository studentRepository;
    private final AvatarRepository avatarRepository;
    private final AvatarPaginAndSortRepository avatarPaginAndSortRepository;
    private final WeatherService weatherService;
    @Value("${path.to.avatars.folder}")
    private String avatarsDir;

    public StudentService(StudentRepository studentRepository,
                          AvatarRepository avatarRepository,
                          AvatarPaginAndSortRepository avatarPaginAndSortRepository,
                          WeatherService weatherService) {
        this.studentRepository = studentRepository;
        this.avatarRepository = avatarRepository;
        this.avatarPaginAndSortRepository = avatarPaginAndSortRepository;
        this.weatherService = weatherService;
    }

    public Student addStudent(Student student) {
        weatherService.logger.info("medod [addStudent]");
        student.setId(null);
        return studentRepository.save(student);
    }

    public Student findStudent(long id) {
        weatherService.logger.info("medod [findStudent]");
        return studentRepository.findById(id).orElseThrow();
    }

    public Student editStudent(Student student) {
        weatherService.logger.info("medod [editStudent]");
        return studentRepository.save(student);
    }

    public void deleteStudent(long id) {
        weatherService.logger.info("medod [deleteStudent]");
        studentRepository.deleteById(id);
    }

    public Collection<Student> findByAge(int age) {
        weatherService.logger.info("medod [findByAge]");
        return studentRepository.findAllByAge(age);
    }

    public Avatar findAvatar(long studentId) {
        weatherService.logger.info("medod [findAvatar]");
        return avatarRepository.findByStudentId(studentId).orElseThrow();
    }

    public void uploadAvatar(Long studentId, MultipartFile file) throws IOException {
        weatherService.logger.info("medod [uploadAvatar]");
        Student student = findStudent(studentId);

        Path filePath = Path.of(avatarsDir, studentId + "." + getExtension(file.getOriginalFilename()));
        Files.createDirectories(filePath.getParent());
        Files.deleteIfExists(filePath);

        try (InputStream is = file.getInputStream();
             OutputStream os = Files.newOutputStream(filePath, CREATE_NEW);
             BufferedInputStream bis = new BufferedInputStream(is, 1024);
             BufferedOutputStream bos = new BufferedOutputStream(os, 1024);
        ) {
            bis.transferTo(bos);
        }

        Avatar avatar = avatarRepository.findByStudentId(studentId).orElseGet(Avatar::new);
        avatar.setStudent(student);
        avatar.setFilePath(filePath.toString());
        avatar.setFileSize(file.getSize());
        avatar.setMediaType(file.getContentType());
        avatar.setData(file.getBytes());
        avatarRepository.save(avatar);
    }

    private String getExtension(String fileName) {
        weatherService.logger.info("medod [getExtension]");
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }


    public int findAllStudentParam() {
        weatherService.logger.info("medod [findAllStudentParam]");
        return studentRepository.findByStudentId();
    }

    public Collection<Student> studentFive() {
        weatherService.logger.info("medod [studentFive]");
        return studentRepository.studentFive();
    }


    public List<Avatar> getAllExpenses(Integer pageNumber, Integer pageSize) {
        weatherService.logger.info("medod [getAllExpenses]");
        PageRequest pageRequest = PageRequest.of(pageNumber - 1, pageSize);
        return avatarRepository.findAll(pageRequest).getContent();
    }

    public float averageAgeStudent() {
        weatherService.logger.info("medod [averageAgeStudent]");
        return studentRepository.averega();
    }

}
