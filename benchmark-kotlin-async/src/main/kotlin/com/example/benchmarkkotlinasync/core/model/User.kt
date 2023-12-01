package com.example.benchmarkkotlinasync.core.model;

import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table("a_user")
data class User(
        val id: UUID,
        val firstName: String,
        val lastName: String)
