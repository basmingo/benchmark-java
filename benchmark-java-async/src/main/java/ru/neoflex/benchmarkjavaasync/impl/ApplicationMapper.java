package ru.neoflex.benchmarkjavaasync.impl;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.neoflex.benchmarkjavaasync.core.model.*;

import java.util.UUID;

@Service
public class ApplicationMapper {

    public Mono<Application> mapToApplication(ApplicationRequest application) {
        return Mono.just(
                new Application(
                        UUID.randomUUID(),
                        application.firstName(),
                        application.lastName(),
                        application.passportSerialNumber(),
                        application.passportNumber(),
                        application.amount(),
                        application.status())
        );
    }

    public Mono<CreditInformation> mapToCreditInformation(Application application) {
        return Mono.just(
                new CreditInformation(
                        UUID.randomUUID(),
                        application.status(),
                        application.amount(),
                        application.userId()
                )
        );
    }

    public Mono<User> mapToUser(Application application) {
        return Mono.just(
                new User(
                        application.userId(),
                        application.firstName(),
                        application.lastName()
                )
        );
    }

    public Mono<Passport> mapToPassport(Application application) {
        return Mono.just(
                new Passport(
                        UUID.randomUUID(),
                        application.passportSerialNumber(),
                        application.passportNumber(),
                        application.userId()
                ));
    }

    public Mono<ApplicationResponse> mapToResult(UUID userId) {
        return Mono.just(
                new ApplicationResponse(userId)
        );
    }
}
