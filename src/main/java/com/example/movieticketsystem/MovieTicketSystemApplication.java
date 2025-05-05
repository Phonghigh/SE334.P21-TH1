package com.example.movieticketsystem;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
// import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EntityScan("com.example.movieticketsystem.model")
@EnableJpaRepositories("com.example.movieticketsystem.repository")
public class MovieTicketSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(MovieTicketSystemApplication.class, args);
    }
}

