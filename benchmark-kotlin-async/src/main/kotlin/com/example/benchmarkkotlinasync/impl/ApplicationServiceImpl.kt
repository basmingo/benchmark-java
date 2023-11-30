package com.example.benchmarkkotlinasync.impl;

import com.example.benchmarkkotlinasync.core.ApplicationRepository
import com.example.benchmarkkotlinasync.core.ApplicationService
import com.example.benchmarkkotlinasync.core.model.*
import com.example.benchmarkkotlinasync.core.model.ApplicationResponse
import com.example.benchmarkkotlinasync.core.model.ApplicationServiceRequest
import com.example.benchmarkkotlinasync.core.model.Passport
import com.example.benchmarkkotlinasync.core.model.User
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import java.math.BigDecimal

import java.util.UUID;

@Service
@Slf4j
class ApplicationServiceImpl @Autowired constructor(
    val applicationRepository: ApplicationRepository<UUID, Unit>,
    val applicationMapper: ApplicationMapper
) : ApplicationService<ApplicationResponse> {

    override suspend fun process(applicationServiceRequest: ApplicationServiceRequest): ApplicationResponse {
        applicationRepository.saveUser(User(UUID.randomUUID(), "!", "!"))
        applicationRepository.savePassport(Passport(UUID.randomUUID(), 1234, 123455, UUID.randomUUID()))

        applicationRepository.saveCreditInformation(
            CreditInformation(
                UUID.randomUUID(),
                "!",
                BigDecimal.TEN,
                UUID.randomUUID()
            )
        )

        val a = applicationMapper.mapToApplication(applicationServiceRequest)

        println(a)
        return ApplicationResponse(UUID.randomUUID())
    }
}
