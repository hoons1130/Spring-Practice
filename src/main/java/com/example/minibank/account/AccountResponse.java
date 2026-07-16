package com.example.minibank.account;

import java.math.BigDecimal;

public record AccountResponse(
        Long id,
        Long customerId,
        String accountNumber,
        BigDecimal balance,
        AccountStatus status
) {
    public static AccountResponse from(Account account) {
        return new AccountResponse(
                account.getId(),
                account.getCustomerId(),
                account.getAccountNumber(),
                account.getBalance(),
                account.getStatus()
        );
    }
}
