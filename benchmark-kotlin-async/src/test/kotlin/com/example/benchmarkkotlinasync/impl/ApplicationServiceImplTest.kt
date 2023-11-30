package com.example.benchmarkkotlinasync.impl

import com.example.benchmarkkotlinasync.core.ApplicationService
import com.example.benchmarkkotlinasync.core.model.ApplicationResponse
import com.example.benchmarkkotlinasync.core.model.ApplicationServiceRequest
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.math.BigDecimal

@SpringBootTest
class ApplicationServiceImplTest {

    @Autowired
    lateinit var sut: ApplicationServiceImpl

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