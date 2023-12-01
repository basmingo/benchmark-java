package com.example.benchmarkkotlinasync.impl

import com.example.benchmarkkotlinasync.core.model.ApplicationServiceRequest
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
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