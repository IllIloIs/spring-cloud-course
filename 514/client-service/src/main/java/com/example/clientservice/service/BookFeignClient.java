package com.example.clientservice.service;

import com.example.clientservice.entity.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "book-service")
public interface BookFeignClient {

    @GetMapping("/api/books")
    List<Book> getAllBooks();
}
