package com.example.benchmarkkotlinasync.impl;

import com.example.benchmarkkotlinasync.core.ApplicationRepository
import com.example.benchmarkkotlinasync.core.model.CreditInformation
import com.example.benchmarkkotlinasync.core.model.Passport
import com.example.benchmarkkotlinasync.core.model.User
import kotlinx.coroutines.delay
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service
import java.util.*

@Service
@RequiredArgsConstructor
class ApplicationDao : ApplicationRepository<UUID, Unit> {
    override suspend fun saveUser(user: User): UUID {
        delay(1000)
        (1..100).forEach { println("save user $it")}
        return UUID.randomUUID()
    }

    override fun saveCreditInformation(creditInformation: CreditInformation): Unit {
        (1..100).forEach { println("save credit info $it")}
    }

    override fun savePassport(passport: Passport): Unit {
        (1..100).forEach { println("save passport $it")}
    }
}
