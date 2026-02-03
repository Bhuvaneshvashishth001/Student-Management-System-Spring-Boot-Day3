package com.example.day3sms.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
//@Data // no need when getter and setter constructor is already specified because it have more constructors which are not needed
@AllArgsConstructor
@NoArgsConstructor
@Document (collection = "students")

public class studentmodel {

    @Id
    private String id;
    private String name;
    private int age;
    private String email;

}
