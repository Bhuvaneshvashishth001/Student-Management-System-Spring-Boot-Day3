package com.example.day3sms.service;


import com.example.day3sms.model.studentmodel;
import com.example.day3sms.repository.studentRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class studentService {

    private final studentRepo repository;

    public studentService(studentRepo repository) {
        this.repository = repository;
    }

    public studentmodel addStudent(studentmodel student){

        return repository.save(student);
    }
    // Display student
    public List<studentmodel> getStudents(){
        return repository.findAll();
    }
    // update

    public studentmodel updateStudent(String id,studentmodel student) {
        studentmodel existingStudent = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("No Student found"));
        existingStudent.setName(student.getName());
        existingStudent.setAge(student.getAge());
        existingStudent.setEmail(student.getEmail());

        return repository.save(existingStudent);
    }

    public studentmodel deleteStudent(String id){
        studentmodel student = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("No Student found"));
        repository.deleteById(id);
        return student;
    }

}
