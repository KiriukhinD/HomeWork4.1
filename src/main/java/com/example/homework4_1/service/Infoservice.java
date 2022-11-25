package com.example.homework4_1.service;

import com.example.homework4_1.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.LongStream;


@Service
public class Infoservice {
    private final StudentRepository studentRepository;

    public Infoservice(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public long returnNumber() {
        long tyme = System.currentTimeMillis();
        long sum = LongStream.rangeClosed(1, 1_000_000)
                .parallel()
                .reduce(0, Long::sum);
        return System.currentTimeMillis() - tyme;

    }


    public Collection allStudentListNoSinhron() {
        System.out.println(studentRepository.findAll());
        System.out.println("________________________");
        System.out.println(studentRepository.findAll().get(0));
        System.out.println(studentRepository.findAll().get(1));
        new Thread(() -> {
            System.out.println(studentRepository.findAll().get(2));
            System.out.println(studentRepository.findAll().get(3));
        }).start();
        new Thread(() -> {
            System.out.println(studentRepository.findAll().get(4));
            System.out.println(studentRepository.findAll().get(5));
        }).start();
        return studentRepository.findAll();
    }

    public Collection allStudentListSinhron() {
        sinhron();
        return studentRepository.findAll();

    }

    public synchronized void sinhron() {
        System.out.println(studentRepository.findAll());
        System.out.println("________________________");
        System.out.println(studentRepository.findAll().get(0));
        System.out.println(studentRepository.findAll().get(1));
        new Thread(() -> {
            System.out.println(studentRepository.findAll().get(2));
            System.out.println(studentRepository.findAll().get(3));
        }).start();
        new Thread(() -> {
            System.out.println(studentRepository.findAll().get(4));
            System.out.println(studentRepository.findAll().get(5));
        }).start();

    }

}
