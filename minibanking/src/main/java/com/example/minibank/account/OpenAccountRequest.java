package com.example.minibank.account;

import jakarta.validation.constraints.NotNull;

public record OpenAccountRequest(
        @NotNull
        Long customerId
)
{
}
