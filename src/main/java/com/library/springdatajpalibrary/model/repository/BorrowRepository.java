package com.library.springdatajpalibrary.model.repository;

import com.library.springdatajpalibrary.model.entity.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BorrowRepository extends JpaRepository<Borrow , Long> {
    Borrow findByBook_BookIdAndAndMember_MemberId(Long bookId , Long memberId);
    List<Borrow> findAllByReceiveDateLessThanAndReturnDateIsNull(String date);

}
