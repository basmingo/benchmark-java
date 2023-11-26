package ru.neoflex.benchmarkjavaasync.core.model;

import java.util.UUID;

public record User(UUID uuid, String firstName, String lastName) {
}
