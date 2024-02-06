package com.library.springdatajpalibrary.model.repository;

import com.library.springdatajpalibrary.model.entity.Book;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface BookRepository extends JpaRepository<Book , Long> {
    ArrayList<Book> findByBookNameContaining(String bookName);

}
