package com.example.checkbookservice;

import com.example.checkbookservice.model.Book;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication
public class CheckBookServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CheckBookServiceApplication.class, args);
    }

    @Bean
    public Function<Book, Book> checkProcessing() {
        return book -> {
            book.setStatus("checked");
            return book;
        };
    }

    @Bean
    public NewTopic bookTopic() {
        return new NewTopic("check-topic", 3, (short) 1);
    }
}
