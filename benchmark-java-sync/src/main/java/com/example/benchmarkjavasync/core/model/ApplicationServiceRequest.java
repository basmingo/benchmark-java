package com.example.benchmarkjavasync.core.model;

import java.math.BigDecimal;

public record ApplicationServiceRequest(
        String firstName,
        String lastName,
        int passportSerialNumber,
        int passportNumber,
        BigDecimal amount,
        String status) {
}
