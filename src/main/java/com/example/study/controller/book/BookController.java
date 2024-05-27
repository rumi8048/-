package com.example.study.controller.book;

import com.example.study.entity.Book;
import com.example.study.model.AddBookInPut;
import com.example.study.repository.BookRepository;
import com.example.study.service.BookService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    private BookService bookService;
    private BookRepository bookRepository;

    public BookController(BookService bookservice,BookRepository bookRepository){
        this.bookService = bookService;
        this.bookRepository = bookRepository;
    }

    @GetMapping("/book")
    public List<Book> getBooks() {
        List<Book> books = bookRepository.findAll();
        return books;
    }

    @PostMapping("/book")
    public long addBook(@RequestBody @Valid AddBookInPut input){
        long id = bookService.addBook(input);
        return id;
    }
}
