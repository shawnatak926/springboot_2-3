package com.example.ex06.service;


import com.example.ex06.entity.Member;
import com.example.ex06.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//@RequiredArgsConstructor
public class MemberService {

    public final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Member> findAll() {
        return memberRepository.findAll(); // select * from member;
    }

    public Member findById(Long id) {
        //select * from member where id = ?id;
        Optional<Member> optinalMember = memberRepository.findById(id);
        return optinalMember.get();
    }

    public Member save(Member member) {
        return memberRepository.save(member);
    }
}
