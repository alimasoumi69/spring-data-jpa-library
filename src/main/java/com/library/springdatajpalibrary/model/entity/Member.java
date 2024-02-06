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
@Table(name = "MEMBER")
@Builder
public class Member {
    @Id
    @SequenceGenerator(name="member_sequence" , sequenceName = "member_sequence" , allocationSize = 1)
    @GeneratedValue(generator = "member_sequence" , strategy =GenerationType.AUTO )
    private long memberId;
    @Column(columnDefinition = DataType.string_200)
    private String memberName;
    @Column(columnDefinition = DataType.string_10)
    private String nId;
    @Column(columnDefinition = DataType.createDate)
    private String createDate;
    private int count;
}
