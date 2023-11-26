package ru.neoflex.benchmarkjavaasync.core.model;

import java.math.BigDecimal;
import java.util.UUID;

public record CreditInformation(UUID uuid, String status, BigDecimal amount, UUID userId) {
}
