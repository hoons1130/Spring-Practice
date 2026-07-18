package com.example.budget.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "budget_entries")
public class BudgetEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EntryType type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;

    @Column(nullable = false)
    private Long amount;

    private String memo;

    @Column(nullable = false)
    private LocalDate date;

    public BudgetEntry(
            EntryType type,
            Long amount,
            Category category,
            String memo,
            LocalDate date
    ) {
        this.type = type;
        this.amount = amount;
        this.category = category;
        this.memo = memo;
        this.date = date;
    }

    public void update(EntryType type, Long amount) {
        this.type = type;
        this.amount = amount;
    }

}
