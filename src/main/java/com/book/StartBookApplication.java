package com.book;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;

@SpringBootApplication
public class StartBookApplication {

    // start everything
    public static void main(String[] args) {
        SpringApplication.run(StartBookApplication.class, args);
    }

    @Profile("demo")
    @Bean
    CommandLineRunner initDatabase(BookRepository repository) {
        return args -> {
            repository.save(new Book("Postive Thoughs", "Chetan", new BigDecimal("17.71")));
            repository.save(new Book("Way to Success", "Ratan", new BigDecimal("9.69")));
            repository.save(new Book("Refactoring: Improving the Design of Existing Code", "CK Raman", new BigDecimal("47.99")));
            repository.save(new Book("Survival to LIVE", "MAK", new BigDecimal("9.75")));
            
        };
    }
}