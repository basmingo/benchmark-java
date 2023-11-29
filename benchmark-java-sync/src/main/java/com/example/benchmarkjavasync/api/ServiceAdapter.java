package com.example.benchmarkjavasync.api;

import com.example.benchmarkjavasync.core.ApplicationService;
import com.example.benchmarkjavasync.core.model.ApplicationResponse;
import com.example.benchmarkjavasync.core.model.ApplicationServiceRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServiceAdapter {

    private final ApplicationService<Optional<ApplicationResponse>> applicationService;

    public Optional<ApplicationResponse> process(ApplicationRequestDto applicationRequestDto) {
        return applicationService.process(map(applicationRequestDto));

    }

    public ApplicationServiceRequest map(ApplicationRequestDto applicationRequestDto) {
        return new ApplicationServiceRequest(
                applicationRequestDto.firstName(),
                applicationRequestDto.lastName(),
                applicationRequestDto.passportSerialNumber(),
                applicationRequestDto.passportNumber(),
                applicationRequestDto.amount(),
                applicationRequestDto.status()
        );
    }
}
