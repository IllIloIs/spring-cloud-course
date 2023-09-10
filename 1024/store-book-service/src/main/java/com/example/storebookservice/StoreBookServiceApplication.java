package com.example.storebookservice;

import com.example.storebookservice.model.Book;
import com.example.storebookservice.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;

@SpringBootApplication
@RequiredArgsConstructor
public class StoreBookServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(StoreBookServiceApplication.class, args);
    }

    private final BookRepository bookRepository;


    @Bean
    public Consumer<Book> storeProcessing() {
        return bookRepository::save;
    }
}
