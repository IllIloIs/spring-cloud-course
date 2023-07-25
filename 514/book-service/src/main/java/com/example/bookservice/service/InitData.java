package com.example.bookservice.service;

import com.example.bookservice.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class InitData {

    private  BookService service;

    public InitData(BookService service) {
        this.service = service;
    }

    @PostConstruct
     public void init() {
        System.out.println("initializing book!");
        service.saveBook(new Book("1", "Some", "Boring", "goo.gl/some"));
    }
}
