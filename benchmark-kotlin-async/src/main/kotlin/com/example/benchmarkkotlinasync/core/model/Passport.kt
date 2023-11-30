package com.example.benchmarkkotlinasync.core.model;

import java.util.UUID;

data class Passport(
        val id: UUID,
        val serialNumber: Int,
        val number: Int,
        val userId: UUID)
