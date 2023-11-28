package ru.neoflex.benchmarkjavaasync.core.model;

import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Table("a_user")
public record User(
        UUID id,
        String firstName,
        String lastName) {
}
