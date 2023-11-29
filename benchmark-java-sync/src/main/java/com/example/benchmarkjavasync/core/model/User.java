package com.example.benchmarkjavasync.core.model;

import jakarta.persistence.Table;

import java.util.UUID;

@Table(name = "a_name")
public record User(
        UUID id,
        String firstName,
        String lastName) {
}
