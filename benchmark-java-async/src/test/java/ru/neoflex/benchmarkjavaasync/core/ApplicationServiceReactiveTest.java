package ru.neoflex.benchmarkjavaasync.core;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import ru.neoflex.benchmarkjavaasync.core.model.ApplicationResponse;
import ru.neoflex.benchmarkjavaasync.core.model.ApplicationServiceRequest;

import java.math.BigDecimal;

@SpringBootTest
@Testcontainers
class ApplicationServiceReactiveTest {

    @Container
    private static final PostgreSQLContainer<?> POSTGRE_SQL_CONTAINER =
            new PostgreSQLContainer<>("postgres:latest")
                    .withDatabaseName("benchmark-test");

    @Autowired
    ApplicationService<Mono<ApplicationResponse>> applicationService;

    @DynamicPropertySource
    public static void overrideProps(DynamicPropertyRegistry registry) {
        registry.add("spring.liquibase.url", POSTGRE_SQL_CONTAINER::getJdbcUrl);
        registry.add("spring.liquibase.user", POSTGRE_SQL_CONTAINER::getUsername);
        registry.add("spring.liquibase.password", POSTGRE_SQL_CONTAINER::getPassword);

        registry.add("spring.r2dbc.url",
                () -> POSTGRE_SQL_CONTAINER.getJdbcUrl()
                        .replaceAll("jdbc", "r2dbc"));
        registry.add("spring.r2dbc.username", POSTGRE_SQL_CONTAINER::getUsername);
        registry.add("spring.r2dbc.password", POSTGRE_SQL_CONTAINER::getPassword);
    }

    @AfterAll
    public static void tearDown() {
        String logs = POSTGRE_SQL_CONTAINER.getLogs();
        POSTGRE_SQL_CONTAINER.close();
    }

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