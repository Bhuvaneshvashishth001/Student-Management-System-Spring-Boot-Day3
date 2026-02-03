package com.example.day3sms.controller;


import com.example.day3sms.DTO.StudentRequestDto;
import com.example.day3sms.DTO.StudentResponseDto;
import com.example.day3sms.model.studentmodel;
import com.example.day3sms.service.studentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class studentcontroller {
    private final studentService service;

    public studentcontroller(studentService service){
        this.service = service;
    }
    // create function api
    @PostMapping("/add-student")
    public StudentResponseDto addStudent( @Valid @RequestBody StudentRequestDto student){
        return service.addStudent(student);
    }
     @GetMapping("/students")

    public List<StudentResponseDto> getStudents(){
        return service.getAllStudents();
     }

    @PutMapping("/update/{id}")
    public StudentResponseDto updateStudent(
            @PathVariable String id,
            @RequestBody StudentRequestDto dto) {

        return service.updateStudent(id, dto);
    }


    @DeleteMapping("/delete/{id}")
    public StudentResponseDto deleteStudent(@PathVariable String id) {
         return service.deleteStudent(id);
     }
}
