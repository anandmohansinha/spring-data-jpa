package com.java.jpa.repository.mongodb;

import com.java.jpa.entity.mongo.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends MongoRepository<Student, String> {
}