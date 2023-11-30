package com.example.benchmarkkotlinasync

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BenchmarkKotlinAsyncApplication

fun main(args: Array<String>) {
    runApplication<BenchmarkKotlinAsyncApplication>(*args)
}
