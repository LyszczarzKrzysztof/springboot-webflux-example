package com.example.springbootwebfluxexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.mongodb.util.BsonUtils;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class InitService {
    private StudentRepository studentRepository;

    @Autowired
    public InitService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void saveStartEntities() {
        studentRepository.deleteAll()
                .thenMany(Flux.just("Kaja", "Maja", "Stefan", "Szymon", "Krzysiek", "Grzesiek", "Gabriela", "Jozef"))
                .map(name -> new Student(name))
                .flatMap(studentRepository::save)
                .thenMany(studentRepository.findAll())
                .subscribe(System.out::println);

        studentRepository.save(new Student("Tadek123")).subscribe();
    }
}
