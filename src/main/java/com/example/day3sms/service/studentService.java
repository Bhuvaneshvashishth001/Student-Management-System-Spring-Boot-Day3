package com.example.day3sms.service;


import com.example.day3sms.DTO.StudentRequestDto;
import com.example.day3sms.DTO.StudentResponseDto;
import com.example.day3sms.exception.StudentNotFoundException;
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

//    public studentmodel addStudent(studentmodel student){
//
//        return repository.save(student);
//    }

    public StudentResponseDto addStudent(StudentRequestDto dto){
        studentmodel student = new studentmodel();
        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setEmail(dto.getEmail());

        studentmodel saved = repository.save(student);

        return new StudentResponseDto(
                saved.getId(),
                saved.getName(),
                saved.getAge(),
                saved.getEmail()
        );
    }
    // Display student
//    public List<studentmodel> getStudents(){
//        return repository.findAll();
//    }
    public List<StudentResponseDto> getAllStudents(){
        return repository.findAll().stream()
                // it is not necessary that findAll() make list only for response dto so we use stream+ map for response dto
                .map(s-> new StudentResponseDto(
                        s.getId(),
                        s.getName(),
                        s.getAge(),
                        s.getEmail()
                )).toList();
    }

    // update

    public StudentResponseDto updateStudent(String id, StudentRequestDto dto) {

        studentmodel existingStudent = repository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("No Student found"));

        existingStudent.setName(dto.getName());
        existingStudent.setAge(dto.getAge());
        existingStudent.setEmail(dto.getEmail());

        studentmodel updated = repository.save(existingStudent);

        return new StudentResponseDto(
                updated.getId(),
                updated.getName(),
                updated.getAge(),
                updated.getEmail()
        );
    }


    public StudentResponseDto deleteStudent(String id){
        studentmodel student = repository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("No Student found"));
        repository.deleteById(id);
        return mapToDto(student);
    }
    private StudentResponseDto mapToDto(studentmodel student) {
        return new StudentResponseDto(
                student.getId(),
                student.getName(),
                student.getAge(),
                student.getEmail()
        );
    }
}
