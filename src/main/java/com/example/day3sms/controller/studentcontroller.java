package com.example.day3sms.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class studentcontroller {

    @GetMapping("/")
    public String student (){
        return "Home page of student";
    }

}
