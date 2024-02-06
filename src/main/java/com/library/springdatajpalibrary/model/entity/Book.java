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
@Table(name = "BOOK")
@Builder
public class Book {
    @Id
    @SequenceGenerator(name="book_sequence" , sequenceName = "book_sequence" , allocationSize = 1)
    @GeneratedValue(generator = "book_sequence" , strategy =GenerationType.AUTO )
    private long bookId;
    @Column(columnDefinition = DataType.string_200)
    private String bookName;
    @Column(columnDefinition = DataType.string_60)
    private String shabak;
    private int count;
    private int qty;
}
