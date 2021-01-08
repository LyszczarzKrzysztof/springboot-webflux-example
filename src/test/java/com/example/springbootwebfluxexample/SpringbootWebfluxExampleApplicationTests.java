package com.example.springbootwebfluxexample;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootTest
class SpringbootWebfluxExampleApplicationTests {

    @Test
    void contextLoads() {
        Flux.just("Kaja", "Maja", "Stefan", "Szymon", "Krzysiek", "Grzesiek", "Gabriela", "Jozef")
                .filter(name -> name.startsWith("J"))
                .subscribe(System.out::println);
        //Mono.just();
    }

}
