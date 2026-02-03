package com.example.day3sms.exception;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(String message) {
        super(message);
    }
}
/*
controller -> service ->Dto -> repository-> model
 */