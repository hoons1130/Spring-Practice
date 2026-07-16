package com.example.member.service;

import com.example.member.domain.Member;
import com.example.member.dto.MemberCreateRequest;
import com.example.member.dto.MemberResponse;
import com.example.member.dto.MemberUpdateRequest;
import com.example.member.exception.DuplicateEmailException;
import com.example.member.exception.MemberNotFoundException;
import com.example.member.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    @Transactional
    public MemberResponse createMember(MemberCreateRequest request) {

        if (memberRepository.existsByEmail(request.email())) {
            throw new DuplicateEmailException(request.email());
        }

        Member member = new Member(
                request.name(),
                request.email()
        );

        Member savedMember = memberRepository.save(member);

        return MemberResponse.from(savedMember);
    }
    public List<MemberResponse> findAllMembers() {
        return memberRepository.findAll()
                .stream()
                .map(MemberResponse::from)
                .toList();
    }

    public MemberResponse findMember(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() ->
                        new MemberNotFoundException(id)
                );

        return MemberResponse.from(member);
    }
    @Transactional
    public MemberResponse updateMember(
            Long id,
            MemberUpdateRequest request
    ) {
        Member member = memberRepository.findById(id).orElseThrow(()-> new MemberNotFoundException(id));

        if (memberRepository.existsByEmailAndIdNot(request.email(), id)) {
            throw new DuplicateEmailException(request.email());
        }

        member.update(
                request.name(),
                request.email());
        return MemberResponse.from(member);
    }
    @Transactional
    public void deleteMember(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(()-> new MemberNotFoundException(id));
        memberRepository.delete(member);
    }
}
