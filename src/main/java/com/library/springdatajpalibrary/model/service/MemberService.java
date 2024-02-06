package com.library.springdatajpalibrary.model.service;
import com.library.springdatajpalibrary.common.DateConverter;
import com.library.springdatajpalibrary.dto.MemberRequest;
import com.library.springdatajpalibrary.model.entity.Member;
import com.library.springdatajpalibrary.model.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    public Member save(MemberRequest memberRequest) {
        Member member = Member.builder()
                .memberName(memberRequest.getMemberName()).nId(memberRequest.getNId()).createDate(new DateConverter().getGregorianDate()).build();
        return memberRepository.save(member);
    }
    public Member findOne(long id){
        return memberRepository.findById(id).get();
    }
    public Member merge(Member member){
        return memberRepository.save(member);
    }
}
