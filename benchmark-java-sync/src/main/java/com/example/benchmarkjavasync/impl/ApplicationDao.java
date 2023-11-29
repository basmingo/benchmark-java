package com.example.benchmarkjavasync.impl;

import com.example.benchmarkjavasync.core.ApplicationRepository;
import com.example.benchmarkjavasync.core.model.CreditInformation;
import com.example.benchmarkjavasync.core.model.Passport;
import com.example.benchmarkjavasync.core.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ApplicationDao implements ApplicationRepository<Optional<UUID>, Void> {

    private final JdbcTemplate template;

    @Override
    public Optional<UUID> saveUser(User user) {
        template.update("insert into a_user values (?, ?, ?)",
                user.id(),
                user.firstName(),
                user.lastName()
        );
        return Optional.of(user.id());
    }

    @Override
    public Void saveCreditInformation(CreditInformation creditInformation) {
        template.update("insert into credit_information values (?, ?, ?, ?)",
                creditInformation.id(),
                creditInformation.amount(),
                creditInformation.status(),
                creditInformation.userId()

        );
        return null;
    }

    @Override
    public Void savePassport(Passport passport) {
        template.update("insert into passport values (?, ?, ?, ?)",
                passport.id(),
                passport.serialNumber(),
                passport.number(),
                passport.userId()
        );
        return null;
    }
}
