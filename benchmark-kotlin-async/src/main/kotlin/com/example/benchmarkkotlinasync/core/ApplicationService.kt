package com.example.benchmarkkotlinasync.core;

import com.example.benchmarkkotlinasync.core.model.ApplicationServiceRequest

interface ApplicationService<T> {

    suspend fun process(applicationServiceRequest: ApplicationServiceRequest): T
}
