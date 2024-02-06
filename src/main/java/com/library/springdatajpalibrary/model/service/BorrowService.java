package com.library.springdatajpalibrary.model.service;


import com.library.springdatajpalibrary.common.DateConverter;
import com.library.springdatajpalibrary.dto.APIResponse;
import com.library.springdatajpalibrary.dto.BorrowRequest;
import com.library.springdatajpalibrary.model.entity.Book;
import com.library.springdatajpalibrary.model.entity.Borrow;
import com.library.springdatajpalibrary.model.entity.Member;
import com.library.springdatajpalibrary.model.repository.BorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BorrowService {
    @Autowired
    BorrowRepository borrowRepository;
    @Autowired
    BookService bookService;
    @Autowired
    MemberService memberService;

    public APIResponse<Borrow> save(BorrowRequest borrowRequest) {
        Book book = bookService.findOne(borrowRequest.getBook());
        Member member = memberService.findOne(borrowRequest.getMember());
        if (book.getQty() >= book.getCount() || member.getCount() >= 3) {
            //staus 0 : condition is not
            return new APIResponse<Borrow>(new Borrow(), 0);
        }
        book.setQty(book.getQty()+1);
        bookService.merge(book);
        member.setCount(member.getCount()+1);
        memberService.merge(member);
        Borrow borrow = Borrow.builder().book(book).member(member).receiveDate(new DateConverter().getGregorianDate()).isReturnBook(false).build();
        return new APIResponse<Borrow>(borrowRepository.save(borrow), 1);

    }


    public Borrow returnBook(BorrowRequest borrowRequest) {
       Borrow borrow=borrowRepository.findByBook_BookIdAndAndMember_MemberId(borrowRequest.getBook(), borrowRequest.getMember());
       borrow.setReturnBook(true);
       borrow.setReturnDate(new DateConverter().getGregorianDate());
       Book book=borrow.getBook();
        book.setQty(book.getQty()-1);
        bookService.merge(book);
        Member member=borrow.getMember();
        member.setCount(member.getCount()-1);
        memberService.merge(member);
        return borrowRepository.save(borrow);
    }
    public List<Borrow> showListTwoWeek()
    {
        DateConverter dateConverter =  new DateConverter();
        dateConverter.previousDay(6);
        List<Borrow> borrowList = borrowRepository.findAllByReceiveDateLessThanAndReturnDateIsNull(dateConverter.getGregorianDate());
        return borrowList;
    }

}
