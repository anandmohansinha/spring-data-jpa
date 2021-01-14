package com.java.jpa.controller;

import com.java.jpa.entity.mongo.Student;
import com.java.jpa.repository.mongodb.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MongoDBController {

    @Autowired
    RegistrationRepository registrationRepository;

    @GetMapping("/all")
    public List<Student> getAllStudent(){
        return registrationRepository.findAll();
    }
}
