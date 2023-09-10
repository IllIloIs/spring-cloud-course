package com.example.checkbookservice.processor;

import com.example.checkbookservice.model.Book;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@AllArgsConstructor
@Slf4j
public class CheckBookEventProcessor implements Function<Message<Book>, Message<Book>> {
    @Override
    public Message<Book> apply(Message<Book> bookMessage) {
        Book receivedBook = bookMessage.getPayload();
        log.info("received book: {}", receivedBook);
        return MessageBuilder.withPayload(
                Book.builder()
                        .id(receivedBook.getId())
                        .name(receivedBook.getName())
                        .price(receivedBook.getPrice())
                        .description(receivedBook.getDescription())
                        .status("checked")
                        .build()
        ).build();
    }
}
