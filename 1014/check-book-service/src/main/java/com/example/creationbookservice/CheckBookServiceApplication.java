package com.example.creationbookservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
public class CheckBookServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CheckBookServiceApplication.class, args);
    }
}
