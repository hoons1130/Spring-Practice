package com.example.todolist.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "todo")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String list;

    @Column(nullable = false)
    private LocalDate date;

    public Todo(
            String name,
            String list,
            LocalDate date
    ) {
        this.name = name;
        this.list = list;
        this.date = date;
    }

    public void update(
            String name,
            String list
    ) {
        this.name = name;
        this.list = list;
    }
}