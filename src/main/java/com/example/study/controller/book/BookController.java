package com.example.study.controller.book;

import com.example.study.entity.Book;
import com.example.study.model.AddBookInPut;
import com.example.study.repository.BookRepository;
import com.example.study.service.BookService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {
    private BookService bookService;
    private BookRepository bookRepository;

    public BookController(BookService bookservice,BookRepository bookRepository){
        this.bookService = bookService;
        this.bookRepository = bookRepository;
    }

//    @GetMapping("/book")
//    public List<Book> getBooks() {
//        List<Book> books = bookRepository.findAll();
//        return books;
//    }

    @PostMapping("/book")
    public long addBook(@RequestBody @Valid AddBookInPut input){
        long id = bookService.addBook(input);
        return id;
    }

    @PutMapping("/book/{id}")
    public void updateBook(
            @PathVariable long id,
            @RequestBody AddBookInPut input
    ){
        bookService.updateBook(id,input);
    }

    @GetMapping("/book")
    public ResponseEntity<Page<Book>> getBooks(@PageableDefault Pageable pageable){
        return ResponseEntity.ok(
                bookService.getBooks(pageable)
        );
    }
}
