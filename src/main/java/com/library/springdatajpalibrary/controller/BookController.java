package com.library.springdatajpalibrary.controller;

import com.library.springdatajpalibrary.dto.BookRequest;
import com.library.springdatajpalibrary.model.entity.Book;
import com.library.springdatajpalibrary.model.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;
    @PostMapping("/save")
    @CrossOrigin(origins = "*")
    public Book create(@RequestBody BookRequest bookRequest){
        return bookService.save(bookRequest);
    }
    @GetMapping("/search")
    @CrossOrigin(origins = "*")
    public List<Book> find(@RequestParam String name) {
        return  bookService.search(name);
    }
}
