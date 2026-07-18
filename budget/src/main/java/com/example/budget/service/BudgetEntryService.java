package com.example.budget.service;

import com.example.budget.domain.BudgetEntry;
import com.example.budget.dto.BudgetEntryCreateRequest;
import com.example.budget.dto.BudgetEntryResponse;
import com.example.budget.repository.BudgetEntryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BudgetEntryService {

    private final BudgetEntryRepository budgetEntryRepository;

    @Transactional
    public BudgetEntryResponse create(BudgetEntryCreateRequest request) {
        BudgetEntry budgetEntry = new BudgetEntry(
                request.type(),
                request.amount(),
                request.category(),
                request.memo(),
                request.date()
        );
        BudgetEntry savedEntry = budgetEntryRepository.save(budgetEntry);
        return BudgetEntryResponse.from(savedEntry);
    }

    //여러개 나오니깐 List로
    public List<BudgetEntryResponse> findAll() {
        List<BudgetEntry> budgetEntries = budgetEntryRepository.findAll();
        return budgetEntries.stream().map(BudgetEntryResponse::from).toList();
    }

    public BudgetEntryResponse find(Long id) {
        BudgetEntry budgetEntry = budgetEntryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 가계부 내역이 없습니다."));

        return BudgetEntryResponse.from(budgetEntry);
    }

    public void delete(Long id) {

        if (!budgetEntryRepository.existsById(id)) {
            throw new IllegalArgumentException("해당 가계부 내역이 없습니다.");
        }

        budgetEntryRepository.deleteById(id);
    }

    @Transactional
    public BudgetEntryResponse update(Long id, BudgetEntryCreateRequest request) {
        BudgetEntry budgetEntry = budgetEntryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 가계부 내역이 없습니다."));

        budgetEntry.update(
                request.type(),
                request.amount());
        return BudgetEntryResponse.from(budgetEntry);
    }
}
