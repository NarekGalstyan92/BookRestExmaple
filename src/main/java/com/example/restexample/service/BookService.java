package com.example.restexample.service;

import com.example.restexample.exception.EntityNotFundException;
import com.example.restexample.model.Book;
import com.example.restexample.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public Book save(Book book) {
        if (book == null) {
            throw new RuntimeException("Book can not be null");
        }
        return bookRepository.save(book);
    }

    public Book getById(int id) throws EntityNotFundException {
        Optional<Book> byId = bookRepository.findById(id);
        if (byId.isEmpty()) {
            throw new EntityNotFundException("Book with " + id + " id does not exist");
        }
        return byId.get();
    }

}
