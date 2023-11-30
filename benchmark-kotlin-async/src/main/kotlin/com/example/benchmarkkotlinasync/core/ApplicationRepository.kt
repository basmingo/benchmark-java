package com.example.benchmarkkotlinasync.core;

import com.example.benchmarkkotlinasync.core.model.CreditInformation
import com.example.benchmarkkotlinasync.core.model.Passport
import com.example.benchmarkkotlinasync.core.model.User

interface ApplicationRepository<R, V> {

    suspend fun saveUser(user: User): R

    fun saveCreditInformation(creditInformation: CreditInformation): V

    fun savePassport(passport: Passport): V
}
