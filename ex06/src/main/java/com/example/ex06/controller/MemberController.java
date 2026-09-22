package com.example.ex06.controller;

import com.example.ex06.entity.Member;
import com.example.ex06.repository.MemberRepository;
import com.example.ex06.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("members")
@RequiredArgsConstructor
@CrossOrigin
public class MemberController {

    // 2가지...@Autowird private fianl
    private final MemberService memberService;

//    public MemberController(MemberService memberService) {
//        this.memberService = memberService;
//    }

    // members 호출 하게 되면...
//    @GetMapping("members")
    @GetMapping
    public List<Member> findAll() {
        return memberService.findAll();
    }

    @GetMapping("/{id}")
    public Member findById(@PathVariable Long id){
        System.out.println("id = "+id);
        Member member = memberService.findById(id);
        return member;
    }

    @PostMapping
    public Member save(@RequestBody Member member){
        return memberService.save(member);
    }

    @PutMapping
    public Member update(
            @PathVariable Long id,
            @RequestBody Member member
    ) throws Exception {
        return memberService.update(id, member);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "회원을 삭제합니다")
    public boolean delete(@PathVariable Long id) throws Exception {
        boolean result = memberService.deleteMember(id);
        return result;
    }
}