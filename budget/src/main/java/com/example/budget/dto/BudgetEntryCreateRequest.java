package com.example.budget.dto;

import com.example.budget.domain.Category;
import com.example.budget.domain.EntryType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public record BudgetEntryCreateRequest(

        @NotNull EntryType type,
        @NotBlank
        @Positive
        Long amount,
        @NotNull Category category,
        String memo,
        @NotBlank LocalDate date
) {
}
