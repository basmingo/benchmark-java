package com.example.benchmarkkotlinasync.api;

import com.example.benchmarkkotlinasync.core.ApplicationService
import com.example.benchmarkkotlinasync.core.model.ApplicationResponse
import com.example.benchmarkkotlinasync.core.model.ApplicationServiceRequest
import org.springframework.stereotype.Service

@Service
class ServiceAdapter(private val applicationService: ApplicationService<ApplicationResponse>) {

    suspend fun process(applicationRequestDto: ApplicationRequestDto): ApplicationResponse =
        applicationService.process(map(applicationRequestDto))

    suspend fun map(applicationRequestDto: ApplicationRequestDto): ApplicationServiceRequest =
        ApplicationServiceRequest(
            applicationRequestDto.firstName,
            applicationRequestDto.lastName,
            applicationRequestDto.passportSerialNumber,
            applicationRequestDto.passportNumber,
            applicationRequestDto.amount,
            applicationRequestDto.status
        )
}
