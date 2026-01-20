package com.example.day3sms.service;


import com.example.day3sms.model.studentmodel;
import com.example.day3sms.repository.studentRepo;
import org.springframework.stereotype.Service;

@Service
public class studentService {

    private final studentRepo repository;

    public studentService(studentRepo repository) {
        this.repository = repository;
    }

    public studentmodel addStudent(studentmodel student){
        return repository.save(student);
    }

}
