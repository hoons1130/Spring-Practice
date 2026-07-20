package com.example.todolist.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record TodoCreateRequest(
        @NotBlank
        String name,

        @NotBlank
        String list
) {
}
