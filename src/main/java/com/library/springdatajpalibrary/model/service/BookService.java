package com.library.springdatajpalibrary.model.service;

import com.library.springdatajpalibrary.dto.BookRequest;
import com.library.springdatajpalibrary.model.entity.Book;
import com.library.springdatajpalibrary.model.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public Book save(BookRequest bookRequest) {
        Book book = Book.builder()
        .bookName(bookRequest.getBookName()).shabak(bookRequest.getShabak()).count(bookRequest.getCount()).build();
        return bookRepository.save(book);
    }
    public List<Book> search(String bookName){
           List <Book>  books =bookRepository.findByBookNameContaining(bookName);
           return books;
    }
    public Book findOne(long id){
        return bookRepository.findById(id).get();
    }
    public Book merge(Book book){
        return bookRepository.save(book);
    }

}
