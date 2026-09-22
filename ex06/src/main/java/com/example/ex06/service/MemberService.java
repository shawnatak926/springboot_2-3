package com.example.ex06.service;


import com.example.ex06.entity.Member;
import com.example.ex06.repository.MemberRepository;
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

    public Member update(Long id, Member member) throws Exception {
        Optional<Member> memberOptional = memberRepository.findById(id);
        System.out.println(memberOptional.get());
        System.out.println(member);
        if(memberOptional.isPresent()){
            memberRepository.save(member);
            return memberRepository.save(member);
        }else{
            throw new Exception("해당하는 id" + id + "가 없어 수정할 수 없습니다.");
        }
    }

    public boolean deleteMember(Long id) throws Exception {
        Member member = memberRepository
                .findById(id)
                .orElseThrow(() -> new Exception("해당하는 id" + id + "가 없어 수정할 수 없습니다."));
        memberRepository.delete(member);
        return true;
    }
}
