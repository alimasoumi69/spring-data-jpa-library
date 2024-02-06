package com.library.springdatajpalibrary.controller;

import com.library.springdatajpalibrary.dto.BookRequest;
import com.library.springdatajpalibrary.dto.MemberRequest;
import com.library.springdatajpalibrary.model.entity.Book;
import com.library.springdatajpalibrary.model.entity.Member;
import com.library.springdatajpalibrary.model.service.BookService;
import com.library.springdatajpalibrary.model.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
public class MemberController {
    @Autowired
    MemberService memberService;
    @PostMapping("/save")
    @CrossOrigin(origins = "*")
    public Member create(@RequestBody MemberRequest memberRequest){
        return memberService.save(memberRequest);
    }

}
