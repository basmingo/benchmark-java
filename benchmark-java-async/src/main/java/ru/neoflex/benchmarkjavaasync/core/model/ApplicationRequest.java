package ru.neoflex.benchmarkjavaasync.core.model;

import java.math.BigDecimal;

public record ApplicationRequest(
        String firstName,
        String lastName,
        int passportSerialNumber,
        int passportNumber,
        BigDecimal amount,
        String status) {
}
