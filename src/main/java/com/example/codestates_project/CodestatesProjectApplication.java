package com.example.codestates_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CodestatesProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodestatesProjectApplication.class, args);
    }

}
