package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student zoro = new Student(
                    1L,
                    "Zoro",
                    "kingofhell@onepiece.com",
                    LocalDate.of(1998, Month.JUNE, 29)
            );

            Student luffy = new Student(
                    "Luffy",
                    "kingofpirates@onepiece.com",
                    LocalDate.of(1999, Month.MAY, 10)
            );

            repository.saveAll(
                    List.of(zoro, luffy)
            );
        };
    }

}
