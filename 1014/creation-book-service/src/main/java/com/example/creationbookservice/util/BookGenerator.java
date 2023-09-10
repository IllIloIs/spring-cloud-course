package com.example.creationbookservice.util;

import com.example.creationbookservice.model.Book;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class BookGenerator {
    private final Random rnd = new Random();

    public Book createNewBook() {
        int randomBookId = rnd.nextInt(10);
        String randomName = "book_" + randomBookId;
        String randomDescription = "desc_"+ randomBookId;
        String status = "unchecked";
        int randomPrice = ++randomBookId;

        return Book.builder()
                .id(randomBookId)
                .description(randomDescription)
                .price(randomPrice)
                .status(status)
                .build();
    }
}
