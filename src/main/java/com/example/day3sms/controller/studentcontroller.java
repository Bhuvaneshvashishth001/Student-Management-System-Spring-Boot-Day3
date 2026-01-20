package com.example.day3sms.controller;


import com.example.day3sms.model.studentmodel;
import com.example.day3sms.service.studentService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class studentcontroller {
    private final studentService service;

    public studentcontroller(studentService service){
        this.service = service;
    }
    // create function api
    @PostMapping("/add-student")
    public studentmodel addStudent(@RequestBody studentmodel student){
        return service.addStudent(student);
    }
}
