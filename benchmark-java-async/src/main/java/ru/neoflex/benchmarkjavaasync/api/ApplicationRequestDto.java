package ru.neoflex.benchmarkjavaasync.api;

import java.math.BigDecimal;
import java.util.UUID;

public record ApplicationRequestDto(
        String firstName,
        String lastName,
        int passportSerialNumber,
        int passportNumber,
        BigDecimal amount,
        String status) {
}
