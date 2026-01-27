package com.example.day3sms.controller;


import com.example.day3sms.model.studentmodel;
import com.example.day3sms.service.studentService;
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
    public studentmodel addStudent(@RequestBody studentmodel student){
        return service.addStudent(student);
    }
     @GetMapping("/students")

    public List<studentmodel> getStudents(){
        return service.getStudents();
     }

     @PutMapping("/update/{id}")
    public studentmodel updateStudent(@PathVariable String id, @RequestBody studentmodel student){
        return service.updateStudent(id,student);
     }

     @DeleteMapping("/delete/{id}")
    public studentmodel deleteStudent(@PathVariable String id) {
         return service.deleteStudent(id);
     }

}
