package ru.neoflex.benchmarkjavaasync.core;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import reactor.blockhound.BlockHound;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import ru.neoflex.benchmarkjavaasync.core.model.ApplicationResponse;
import ru.neoflex.benchmarkjavaasync.core.model.ApplicationServiceRequest;

import java.math.BigDecimal;

@SpringBootTest
@Testcontainers
class ApplicationServiceReactiveTest {

    private static final int PASSPORT_SERIAL_NUMBER = 1234;

    private static final int PASSPORT_NUMBER = 123456;

    @Container
    private static final PostgreSQLContainer<?> POSTGRE_SQL_CONTAINER =
            new PostgreSQLContainer<>("postgres:latest")
                    .withDatabaseName("benchmark-test");

    @Autowired
    ApplicationService<Mono<ApplicationResponse>> applicationService;

    @BeforeAll
    public static void setUp() {
        BlockHound
                .builder()
                .allowBlockingCallsInside("ru.neoflex.benchmarkjavaasync.impl.UUIDUtils", "randomUUID")
                .install();
    }

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
        POSTGRE_SQL_CONTAINER.close();
    }

    @Test
    void applicationServiceProcess_ReturnsApplicationId() {
        StepVerifier
                .create(applicationService.process(
                                new ApplicationServiceRequest(
                                        "test_first_name",
                                        "test_last_name",
                                        PASSPORT_SERIAL_NUMBER,
                                        PASSPORT_NUMBER,
                                        BigDecimal.TEN,
                                        "test_status")
                        )
                )
                .expectNextMatches(it -> it.applicationId() != null)
                .verifyComplete();
    }
}