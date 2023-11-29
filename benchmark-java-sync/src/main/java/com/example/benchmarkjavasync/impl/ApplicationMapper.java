package com.example.benchmarkjavasync.impl;

import com.example.benchmarkjavasync.core.model.*;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ApplicationMapper {

    public Application mapToApplication(ApplicationServiceRequest application) {
        return new Application(
                UUID.randomUUID(),
                application.firstName(),
                application.lastName(),
                application.passportSerialNumber(),
                application.passportNumber(),
                application.amount(),
                application.status()
        );
    }

    public CreditInformation mapToCreditInformation(Application application) {
        return new CreditInformation(
                UUID.randomUUID(),
                application.status(),
                application.amount(),
                application.userId()
        );
    }

    public User mapToUser(Application application) {
        return new User(
                application.userId(),
                application.firstName(),
                application.lastName()
        );
    }

    public Passport mapToPassport(Application application) {
        return new Passport(
                UUID.randomUUID(),
                application.passportSerialNumber(),
                application.passportNumber(),
                application.userId()
        );
    }

    public ApplicationResponse mapToResult(UUID userId) {
        return new ApplicationResponse(userId);
    }
}
