package com.example.budget.dto;

import com.example.budget.domain.BudgetEntry;
import com.example.budget.domain.Category;
import com.example.budget.domain.EntryType;
import java.time.LocalDate;

public record BudgetEntryResponse(
        Long id,
        EntryType type,
        Long amount,
        Category category,
        String memo,
        LocalDate date
) {
    public static BudgetEntryResponse from(BudgetEntry entry) {
        return new BudgetEntryResponse(
                entry.getId(),
                entry.getType(),
                entry.getAmount(),
                entry.getCategory(),
                entry.getMemo(),
                entry.getDate()
        );
    }
}
