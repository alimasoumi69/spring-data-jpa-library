package com.library.springdatajpalibrary.model.repository;

import com.library.springdatajpalibrary.model.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member , Long> {

}
