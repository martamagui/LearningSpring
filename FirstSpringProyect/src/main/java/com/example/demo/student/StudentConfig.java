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
            Student Maria = new Student(
                    "Maria",
                    LocalDate.of(2000, Month.JANUARY, 5),
                    "maria@gmail.com"

            );
            Student Alex = new Student(
                    "Alex",
                    LocalDate.of(2005, Month.JANUARY, 5),
                    "maria@gmail.com"
            );
            //Guarda una lista de estudiantes en la BD
            repository.saveAll(List.of(Maria, Alex));
        };
    }
}
