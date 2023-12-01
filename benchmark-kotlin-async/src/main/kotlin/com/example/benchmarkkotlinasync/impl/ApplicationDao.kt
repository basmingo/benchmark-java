package com.example.benchmarkkotlinasync.impl;

import com.example.benchmarkkotlinasync.core.ApplicationRepository
import com.example.benchmarkkotlinasync.core.model.CreditInformation
import com.example.benchmarkkotlinasync.core.model.Passport
import com.example.benchmarkkotlinasync.core.model.User
import org.springframework.r2dbc.core.DatabaseClient
import org.springframework.r2dbc.core.await
import org.springframework.stereotype.Service
import java.util.*

@Service
class ApplicationDao(private val client: DatabaseClient) : ApplicationRepository<UUID, Unit> {
    override suspend fun saveUser(user: User): UUID {
        client.sql("insert into a_user values (:id, :first_name, :last_name)")
            .bind("id", user.id)
            .bind("first_name", user.firstName)
            .bind("last_name", user.lastName)
            .await()
        return user.id
    }

    override suspend fun saveCreditInformation(creditInformation: CreditInformation) {
        client.sql("insert into credit_information values (:id, :amount, :status, :user_id)")
            .bind("id", creditInformation.id)
            .bind("amount", creditInformation.amount)
            .bind("status", creditInformation.status)
            .bind("user_id",creditInformation.userId)
            .await()
    }

    override suspend fun savePassport(passport: Passport) {
        client.sql("insert into passport values (:id, :serial_number, :number, :user_id)")
            .bind("id", passport.id)
            .bind("serial_number", passport.serialNumber)
            .bind("number", passport.number)
            .bind("user_id",passport.userId)
            .await()
    }
}
