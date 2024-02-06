package com.library.springdatajpalibrary.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowRequest {
    private long book;
    private long member;
//    private String receiveDate;
//    private String returnDate;
//    private boolean isReturn;
}
