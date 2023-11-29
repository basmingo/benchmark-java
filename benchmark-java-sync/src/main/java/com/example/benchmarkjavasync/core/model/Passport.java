package com.example.benchmarkjavasync.core.model;

import java.util.UUID;

public record Passport(
        UUID id,
        int serialNumber,
        int number,
        UUID userId) {
}
