package com.example.study.controller.book;

import com.example.study.controller.entity.Book;
import com.example.study.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/book")
    public List<Book> getBooks() {
        List<Book> books = bookRepository.findAll();
        return books;
    }
}
