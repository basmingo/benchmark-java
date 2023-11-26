package ru.neoflex.benchmarkjavaasync.impl;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.neoflex.benchmarkjavaasync.core.ApplicationRepository;
import ru.neoflex.benchmarkjavaasync.core.model.CreditInformation;
import ru.neoflex.benchmarkjavaasync.core.model.Passport;
import ru.neoflex.benchmarkjavaasync.core.model.User;

import java.util.UUID;

@Service
public class ApplicationDao implements ApplicationRepository<Mono<UUID>, Mono<Void>> {

    @Override
    public Mono<UUID> saveUser(User user) {
        return Mono.just(user)
                .doOnNext(it -> {
                    for (int i = 0; i < 100; i++) {
                        System.out.println("SAVE USER");
                    }
                })
                .map(User::uuid);
    }

    @Override
    public Mono<Void> saveCreditInformation(CreditInformation creditInformation) {
        Mono.just(creditInformation)
                .doOnNext(it -> {
                    for (int i = 0; i < 100; i++) {
                        System.out.println("SAVE CREDIT INFO");
                    }
                })
                .subscribe();
        return Mono.empty();
    }

    @Override
    public Mono<Void> savePassport(Passport passport) {
        Mono.just(passport)
                .doOnNext(it -> {
                    for (int i = 0; i < 100; i++) {
                        System.out.println("SAVE PASSPORT");
                    }
                })
                .subscribe();
        return Mono.empty();
    }
}
