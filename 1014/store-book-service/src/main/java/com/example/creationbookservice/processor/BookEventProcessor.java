package com.example.creationbookservice.processor;

import com.example.creationbookservice.model.Book;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.function.Consumer;
import java.util.function.Supplier;

@Component
@AllArgsConstructor
@Slf4j
public class BookEventProcessor implements Consumer<Message<Book>> {

    @Override
    public void accept(Message<Book> bookMessage) {
        log.info("received book: {}", bookMessage.getPayload());
    }
}
