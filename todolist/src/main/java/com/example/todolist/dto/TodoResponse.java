package com.example.todolist.dto;

import com.example.todolist.domain.Todo;

import java.time.LocalDate;

public record TodoResponse(
        Long id,
        String name,
        String list,
        LocalDate date
) {
    public static TodoResponse from(Todo todo) {
        return new TodoResponse(
                todo.getId(),
                todo.getName(),
                todo.getList(),
                todo.getDate()
        );
    }
}
