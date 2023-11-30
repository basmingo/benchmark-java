package com.example.benchmarkjavasync.impl;

import com.example.benchmarkjavasync.core.ApplicationService;
import com.example.benchmarkjavasync.core.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService<Optional<ApplicationResponse>> {

    private final ApplicationMapper applicationMapper;

    private final ApplicationDao applicationDao;

    @Override
    public Optional<ApplicationResponse> process(ApplicationServiceRequest applicationServiceRequest) {
        Application application = applicationMapper.mapToApplication(applicationServiceRequest);
        CreditInformation creditInformation = applicationMapper.mapToCreditInformation(application);
        User user = applicationMapper.mapToUser(application);
        Passport passport = applicationMapper.mapToPassport(application);

        Optional<UUID> userId = applicationDao.saveUser(user);
        applicationDao.saveCreditInformation(creditInformation);
        applicationDao.savePassport(passport);
        return userId.map(applicationMapper::mapToResult);

    }
}
