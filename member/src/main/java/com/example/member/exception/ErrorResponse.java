package com.example.member.exception;

public record ErrorResponse (int status,
                             String message)
{
}
