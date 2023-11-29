package com.example.benchmarkjavasync.core;

import com.example.benchmarkjavasync.core.model.ApplicationServiceRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
class ApplicationServiceTest {

    @Autowired
    ApplicationService<Optional<UUID>> applicationService;

    @Test
    void test(){
        applicationService.process(new ApplicationServiceRequest(
                "NAme",
                "LastName",
                1234,
                123456,
                BigDecimal.TEN,
                "New"
        ));
    }
}