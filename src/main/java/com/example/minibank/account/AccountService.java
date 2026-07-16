package com.example.minibank.account;

import jakarta.transaction.Transactional;

public class AccountService {
    private final AccountRepository accountRepository;

    @Transactional
    public AccountResponse openAccount(OpenAccountRequest request)

}
