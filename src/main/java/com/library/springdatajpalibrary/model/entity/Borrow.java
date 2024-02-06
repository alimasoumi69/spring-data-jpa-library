package com.library.springdatajpalibrary.model.entity;

import com.library.springdatajpalibrary.util.DataType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BORROW",uniqueConstraints = { @UniqueConstraint(columnNames = { "book_id", "member_id"}) })
@Builder
public class Borrow {
    @Id
    @SequenceGenerator(name="borrow_sequence" , sequenceName = "borrow_sequence" , allocationSize = 1)
    @GeneratedValue(generator = "borrow_sequence" , strategy =GenerationType.AUTO )
    private long borrowId;
    @ManyToOne(targetEntity = Book.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id", referencedColumnName = "bookId")
    private Book book;

    @ManyToOne(targetEntity = Member.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "member_id", referencedColumnName = "memberId")
    private Member member;

    @Column(columnDefinition = DataType.createDate)
    private String receiveDate;

    @Column(columnDefinition = DataType.createDate)
    private String returnDate;

    private boolean isReturnBook;



}
