package com.example.benchmarkkotlinasync.impl;

import com.example.benchmarkkotlinasync.core.ApplicationRepository
import com.example.benchmarkkotlinasync.core.ApplicationService
import com.example.benchmarkkotlinasync.core.model.ApplicationResponse
import com.example.benchmarkkotlinasync.core.model.ApplicationServiceRequest
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import lombok.extern.slf4j.Slf4j
import org.springframework.stereotype.Service
import java.util.*

@Service
@Slf4j
class ApplicationServiceImpl(
    private val applicationRepository: ApplicationRepository<UUID, Unit>,
    private val applicationMapper: ApplicationMapper
) : ApplicationService<ApplicationResponse> {

    override suspend fun process(applicationServiceRequest: ApplicationServiceRequest): ApplicationResponse =
        coroutineScope {
            val application = applicationMapper.mapToApplication(applicationServiceRequest)
            val result = async { applicationRepository.saveUser(applicationMapper.mapToUser(application)) }
            launch { applicationRepository.savePassport(applicationMapper.mapToPassport(application)) }
            launch {
                applicationRepository.saveCreditInformation(applicationMapper.mapToCreditInformation(application))
            }

            return@coroutineScope applicationMapper.mapToResult(result.await())
        }
}
