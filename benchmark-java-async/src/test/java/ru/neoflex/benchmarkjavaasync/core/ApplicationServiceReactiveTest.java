package ru.neoflex.benchmarkjavaasync.core;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import ru.neoflex.benchmarkjavaasync.core.model.ApplicationResponse;
import ru.neoflex.benchmarkjavaasync.core.model.ApplicationServiceRequest;

import java.math.BigDecimal;

@SpringBootTest
class ApplicationServiceReactiveTest {

    @Autowired
    ApplicationService<Mono<ApplicationResponse>> applicationService;

    @Test
    void applicationServiceProcess_ReturnsApplicationId() {
        StepVerifier
                .create(applicationService.process(
                                new ApplicationServiceRequest(
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