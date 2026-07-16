package com.example.member.controller;

import com.example.member.dto.MemberCreateRequest;
import com.example.member.dto.MemberResponse;
import com.example.member.dto.MemberUpdateRequest;
import com.example.member.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/members")
public class MemberController {
    private final MemberService memberService;
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    //회원등록
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MemberResponse createMember(
            @Valid @RequestBody MemberCreateRequest request
    ) {
        return memberService.createMember(request);
    }
    //전체 회원 조회
    @GetMapping
    public List<MemberResponse> findAllMembers() {
        return memberService.findAllMembers();
    }
    //회원 한명 조회
    @GetMapping("/{id}")
    public MemberResponse findMember(
            @PathVariable Long id
    ) {return  memberService.findMember(id);
    }
    @PutMapping("/{id}")
    public MemberResponse updateMember(
            @PathVariable Long id,
            @Valid @RequestBody MemberUpdateRequest request
            ) {
        return memberService.updateMember(id, request);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMember(
            @PathVariable Long id
    )  {
        memberService.deleteMember(id);
    }

}
