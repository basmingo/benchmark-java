package com.example.benchmarkkotlinasync.core.model;

import java.math.BigDecimal
import java.util.*

data class CreditInformation(
        val id: UUID,
        val status: String,
        val amount: BigDecimal,
        val userId: UUID)
