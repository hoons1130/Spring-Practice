package com.example.member;

import com.example.member.dto.MemberCreateRequest;
import com.example.member.dto.MemberResponse;
import com.example.member.exception.DuplicateEmailException;
import com.example.member.repository.MemberRepository;
import com.example.member.service.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @BeforeEach
    void clear() {
        memberRepository.deleteAll();
    }

    @Test
    void test_create() {
        // given
        MemberCreateRequest request =
                new MemberCreateRequest(
                        "홍길동",
                        "hong@example.com"
                );

        // when
        MemberResponse response =
                memberService.createMember(request);

        // then
        assertThat(response.id()).isNotNull();
        assertThat(response.name())
                .isEqualTo("홍길동");
        assertThat(response.email())
                .isEqualTo("hong@example.com");
    }

    @Test
    void test_repeated_email() {
        // given
        memberService.createMember(
                new MemberCreateRequest(
                        "홍길동",
                        "hong@example.com"
                )
        );

        MemberCreateRequest request =
                new MemberCreateRequest(
                        "김철수",
                        "hong@example.com"
                );

        // when & then
        assertThatThrownBy(() ->
                memberService.createMember(request)
        )
                .isInstanceOf(DuplicateEmailException.class);
    }
}