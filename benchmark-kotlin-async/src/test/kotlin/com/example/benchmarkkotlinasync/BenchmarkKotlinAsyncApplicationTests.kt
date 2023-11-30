package com.example.benchmarkkotlinasync

import com.example.benchmarkkotlinasync.core.ApplicationService
import com.example.benchmarkkotlinasync.core.model.ApplicationResponse
import com.example.benchmarkkotlinasync.core.model.ApplicationServiceRequest
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.math.BigDecimal

@SpringBootTest
class BenchmarkKotlinAsyncApplicationTests {

    @Test
    fun contextLoads() {
    }
}
