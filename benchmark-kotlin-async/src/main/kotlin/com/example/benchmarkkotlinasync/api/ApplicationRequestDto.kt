package com.example.benchmarkkotlinasync.api;

import java.math.BigDecimal;

data class ApplicationRequestDto(
    val firstName: String,
    val lastName: String,
    val passportSerialNumber: Int,
    val passportNumber: Int,
    val amount: BigDecimal,
    val status: String
)
