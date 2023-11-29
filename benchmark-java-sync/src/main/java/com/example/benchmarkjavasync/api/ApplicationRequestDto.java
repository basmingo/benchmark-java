package com.example.benchmarkjavasync.api;

import java.math.BigDecimal;

public record ApplicationRequestDto(
        String firstName,
        String lastName,
        int passportSerialNumber,
        int passportNumber,
        BigDecimal amount,
        String status) {
}
