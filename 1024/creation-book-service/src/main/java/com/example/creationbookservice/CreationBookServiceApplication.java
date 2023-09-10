package com.example.creationbookservice;

import com.example.creationbookservice.model.Book;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.function.Supplier;

@SpringBootApplication
@EnableScheduling
public class CreationBookServiceApplication {
    public static int increment = 0;

    public static void main(String[] args) {
        SpringApplication.run(CreationBookServiceApplication.class, args);
    }

    @Bean
    @Scheduled(fixedRate = 10000)
    public Supplier<Book> bookProcessing() {
        return () -> {
            ;
            System.out.println(increment);
            return Book.builder()
                    .id(++increment)
                    .name("Book" + increment)
                    .description("Description" + increment)
                    .status("unchecked")
                    .price(increment * 10)
                    .build();
        };
    }

    @Bean
    public NewTopic bookTopic() {
        return new NewTopic("book-topic", 3, (short) 1);
    }
}
