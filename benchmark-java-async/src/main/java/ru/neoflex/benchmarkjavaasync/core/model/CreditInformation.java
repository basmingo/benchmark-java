package ru.neoflex.benchmarkjavaasync.core.model;

import java.math.BigDecimal;
import java.util.UUID;

public record CreditInformation(
        UUID id,
        String status,
        BigDecimal amount,
        UUID userId) {
}
