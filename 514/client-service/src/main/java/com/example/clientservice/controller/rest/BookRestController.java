package com.example.clientservice.controller.rest;

import com.example.clientservice.entity.Book;
import com.example.clientservice.service.BookFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class BookRestController {
    @Autowired
    private BookFeignClient feignClient;

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return feignClient.getAllBooks();
    }
}
