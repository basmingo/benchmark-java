package com.example.benchmarkkotlinasync.core.model;

import java.math.BigDecimal;

data class ApplicationServiceRequest(
        val firstName: String,
        val lastName: String,
        val passportSerialNumber: Int,
        val passportNumber: Int,
        val amount: BigDecimal,
        val status: String)
