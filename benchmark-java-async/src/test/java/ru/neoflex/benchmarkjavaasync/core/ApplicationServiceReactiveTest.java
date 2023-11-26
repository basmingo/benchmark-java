package ru.neoflex.benchmarkjavaasync.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import ru.neoflex.benchmarkjavaasync.core.model.ApplicationRequest;
import ru.neoflex.benchmarkjavaasync.core.model.ApplicationResponse;
import ru.neoflex.benchmarkjavaasync.impl.ApplicationMapper;
import ru.neoflex.benchmarkjavaasync.impl.ApplicationServiceImpl;

import java.math.BigDecimal;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class ApplicationServiceReactiveTest {

    ApplicationService<Mono<ApplicationResponse>> applicationService;

    @Mock
    ApplicationRepository<Mono<UUID>, Mono<Void>> applicationRepository;

    ApplicationMapper applicationMapper;

    @BeforeEach
    void init() {
        when(applicationRepository.saveUser(any())).thenReturn(Mono.just(UUID.randomUUID()));
        when(applicationRepository.saveCreditInformation(any())).thenReturn(Mono.empty());
        applicationMapper = new ApplicationMapper();
        applicationService = new ApplicationServiceImpl(
                applicationRepository,
                applicationMapper
        );
    }

    @Test
    void applicationServiceProcess_ReturnsApplicationId() {
        StepVerifier
                .create(applicationService.process(
                                new ApplicationRequest(
                                        "Pavel",
                                        "Basmanov",
                                        1234,
                                        123456,
                                        BigDecimal.TEN,
                                        "New")
                        )
                )
                .expectNextMatches(it -> it.applicationId() != null)
                .verifyComplete();
    }
}