package com.example.springbootwebfluxexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
public class StudentApi {

    private StudentRepository studentRepository;

    @Autowired
    public StudentApi(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Student> get() {
       return studentRepository.findAll().delayElements(Duration.ofSeconds(1));
    }

}
