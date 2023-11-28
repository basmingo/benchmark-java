package ru.neoflex.benchmarkjavaasync.impl;

import io.r2dbc.spi.ConnectionFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.neoflex.benchmarkjavaasync.core.ApplicationRepository;
import ru.neoflex.benchmarkjavaasync.core.model.CreditInformation;
import ru.neoflex.benchmarkjavaasync.core.model.Passport;
import ru.neoflex.benchmarkjavaasync.core.model.User;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ApplicationDao implements ApplicationRepository<Mono<UUID>, Mono<Void>> {

    private final R2dbcEntityTemplate r2dbcEntityTemplate;

    @Override
    public Mono<UUID> saveUser(User user) {
        return r2dbcEntityTemplate.insert(user).map(User::id);
    }

    @Override
    public Mono<Void> saveCreditInformation(CreditInformation creditInformation) {
        r2dbcEntityTemplate.insert(creditInformation).subscribe();
        return Mono.empty();
    }

    @Override
    public Mono<Void> savePassport(Passport passport) {
        r2dbcEntityTemplate.insert(passport).subscribe();
        return Mono.empty();
    }
}
