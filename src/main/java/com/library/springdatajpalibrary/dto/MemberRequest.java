package com.library.springdatajpalibrary.dto;

import com.library.springdatajpalibrary.util.DataType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberRequest {
    private String memberName;
    private String nId;
    //ba in shart ke dast user bashad
    private String createDate;

}
