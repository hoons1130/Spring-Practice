package com.example.todolist.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

public record TodoCreateRequest(
        @NotBlank
        String name,

        @NotBlank
        String list,

        @NotBlank
        LocalDate date
) {
}
