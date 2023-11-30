package com.example.benchmarkkotlinasync.impl

import com.example.benchmarkkotlinasync.core.ApplicationService
import com.example.benchmarkkotlinasync.core.model.ApplicationResponse
import com.example.benchmarkkotlinasync.core.model.ApplicationServiceRequest
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.math.BigDecimal

@SpringBootTest
class ApplicationServiceImplTest @Autowired constructor(val sut: ApplicationService<ApplicationResponse>) {

    @Test
    fun process() {
        runBlocking {
            val result = sut.process(
                ApplicationServiceRequest(
                    "Test",
                    "TestLN",
                    1234,
                    123456,
                    BigDecimal.TEN,
                    "!"
                )
            )

            println(result)
        }
    }
}