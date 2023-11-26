package ru.neoflex.benchmarkjavaasync.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import ru.neoflex.benchmarkjavaasync.core.ApplicationService;
import ru.neoflex.benchmarkjavaasync.core.model.*;
import ru.neoflex.benchmarkjavaasync.core.ApplicationRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ApplicationServiceImpl implements ApplicationService<Mono<ApplicationResponse>> {

    private final ApplicationRepository<Mono<UUID>, Mono<Void>> applicationRepository;

    private final ApplicationMapper applicationMapper;

    @Override
    public Mono<ApplicationResponse> process(ApplicationRequest applicationRequest) {
        Mono<Application> application = applicationMapper.mapToApplication(applicationRequest);
        Mono<Passport> passport = application.flatMap(applicationMapper::mapToPassport);
        Mono<CreditInformation> creditInformationMono = application
                .flatMap(applicationMapper::mapToCreditInformation);

        Mono<User> user = application.flatMap(applicationMapper::mapToUser);
        return Mono.zip(passport.doOnNext(applicationRepository::savePassport)
                                .subscribeOn(Schedulers.parallel()),
                        creditInformationMono.doOnNext(applicationRepository::saveCreditInformation)
                                .subscribeOn(Schedulers.parallel()),
                        user.flatMap(applicationRepository::saveUser))
                .flatMap(tuple -> applicationMapper.mapToResult(tuple.getT3()));
    }
}
