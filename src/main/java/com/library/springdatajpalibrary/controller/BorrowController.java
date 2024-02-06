package com.library.springdatajpalibrary.controller;



import com.library.springdatajpalibrary.dto.APIResponse;
import com.library.springdatajpalibrary.dto.BorrowRequest;

import com.library.springdatajpalibrary.model.entity.Borrow;
import com.library.springdatajpalibrary.model.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/borrow")
public class BorrowController {
    @Autowired
    BorrowService borrowService;

    @PostMapping("/save")
    @CrossOrigin(origins = "*")
    public APIResponse<Borrow> create(@RequestBody BorrowRequest borrowRequest){
        return borrowService.save(borrowRequest);
    }
    @PostMapping("/return")
    @CrossOrigin(origins = "*")
    public Borrow returnB(@RequestBody BorrowRequest borrowRequest){

        return borrowService.returnBook(borrowRequest);
    }
    @GetMapping("/showListTwoWeek")
    @CrossOrigin(origins = "*")
    public List<Borrow> show(){

        return borrowService.showListTwoWeek();
    }
}
