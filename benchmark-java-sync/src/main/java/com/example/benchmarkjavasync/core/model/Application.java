package com.example.benchmarkjavasync.core.model;

import java.math.BigDecimal;
import java.util.UUID;

public record Application(
        UUID userId,
        String firstName,
        String lastName,
        int passportSerialNumber,
        int passportNumber,
        BigDecimal amount,
        String status) {
}
