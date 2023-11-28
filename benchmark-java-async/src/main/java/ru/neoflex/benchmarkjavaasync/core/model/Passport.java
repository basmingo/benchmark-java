package ru.neoflex.benchmarkjavaasync.core.model;

import java.util.UUID;

public record Passport(
        UUID id,
        int serialNumber,
        int number,
        UUID userId) {
}
