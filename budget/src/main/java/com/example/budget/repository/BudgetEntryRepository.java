package com.example.budget.repository;

import com.example.budget.domain.BudgetEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BudgetEntryRepository extends JpaRepository<BudgetEntry,Long> {
}
