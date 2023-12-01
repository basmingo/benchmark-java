package com.example.benchmarkkotlinasync.api

import com.example.benchmarkkotlinasync.core.model.ApplicationResponse
import lombok.RequiredArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
@RequiredArgsConstructor
@Slf4j
class ApplicationController(private val applicationService: ServiceAdapter) {

    @PostMapping("users/create")
    suspend fun postUser(@RequestBody userRequestDto: ApplicationRequestDto): ApplicationResponse {
        return applicationService.process(userRequestDto)
    }
}
