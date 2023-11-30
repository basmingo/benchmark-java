package com.example.benchmarkkotlinasync.core.model;

import java.math.BigDecimal;
import java.util.UUID;

data class Application(
        val userId: UUID,
        val firstName: String,
        val lastName: String,
        val passportSerialNumber: Int,
        val passportNumber: Int,
        val amount: BigDecimal,
        val status: String)
