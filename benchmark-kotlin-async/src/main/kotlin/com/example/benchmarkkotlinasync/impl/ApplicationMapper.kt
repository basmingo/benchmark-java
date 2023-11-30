package com.example.benchmarkkotlinasync.impl;

import com.example.benchmarkkotlinasync.core.model.*
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
class ApplicationMapper {

    fun mapToApplication(application: ApplicationServiceRequest): Application {
        return Application(
                UUID.randomUUID(),
                application.firstName,
                application.lastName,
                application.passportSerialNumber,
                application.passportNumber,
                application.amount,
                application.status)
    }

    fun mapToCreditInformation(application: Application): CreditInformation {
        return CreditInformation(
                UUID.randomUUID(),
                application.status,
                application.amount,
                application.userId
        )
    }

    fun mapToUser(application: Application): User {
        return User(
                application.userId,
                application.firstName,
                application.lastName
        )
    }

    fun mapToPassport(application: Application): Passport {
        return Passport(
                UUID.randomUUID(),
                application.passportSerialNumber,
                application.passportNumber,
                application.userId
        )
    }

    fun mapToResult(userId: UUID): ApplicationResponse {
        return ApplicationResponse(userId)
    }
}
