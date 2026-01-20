package com.example.day3sms.repository;

import com.example.day3sms.model.studentmodel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface studentRepo extends MongoRepository <studentmodel,String> {

}
