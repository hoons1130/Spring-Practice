package com.example.member.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name="members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique =true)
    private String email;

    public Member(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void update(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
