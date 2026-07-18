package com.example.budget.controller;

import com.example.budget.dto.BudgetEntryCreateRequest;
import com.example.budget.dto.BudgetEntryResponse;
import com.example.budget.service.BudgetEntryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/budget-entries")
public class BudgetEntryController {

    private final BudgetEntryService budgetEntryService;

    @PostMapping
    public BudgetEntryResponse create(
            @Valid @RequestBody BudgetEntryCreateRequest request)
    { return budgetEntryService.create(request);
    }

    @GetMapping
    public List<BudgetEntryResponse> findAll() {
        return budgetEntryService.findAll();
    }

    @GetMapping("/{id}")
    public BudgetEntryResponse find(@PathVariable Long id) {
        return budgetEntryService.find(id);
    }

    @PutMapping("/{id}")
    public BudgetEntryResponse update(
            @PathVariable Long id,
            @Valid @RequestBody BudgetEntryCreateRequest request
    ) {
        return budgetEntryService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id
    ) {
        budgetEntryService.delete(id);
    }
}
