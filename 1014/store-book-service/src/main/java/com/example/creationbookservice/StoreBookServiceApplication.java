package com.example.creationbookservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
public class StoreBookServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(StoreBookServiceApplication.class, args);
    }
}
