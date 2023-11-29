package ru.neoflex.benchmarkjavaasync.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.neoflex.benchmarkjavaasync.core.ApplicationService;
import ru.neoflex.benchmarkjavaasync.core.model.ApplicationResponse;
import ru.neoflex.benchmarkjavaasync.core.model.ApplicationServiceRequest;

@Service
@RequiredArgsConstructor
public class ServiceAdapter {

    private final ApplicationService<Mono<ApplicationResponse>> applicationService;

    public Mono<ApplicationResponse> process(ApplicationRequestDto applicationRequestDto) {
        return map(applicationRequestDto)
                .flatMap(applicationService::process);
    }

    public Mono<ApplicationServiceRequest> map(ApplicationRequestDto applicationRequestDto) {
        return Mono.just(new ApplicationServiceRequest(
                applicationRequestDto.firstName(),
                applicationRequestDto.lastName(),
                applicationRequestDto.passportSerialNumber(),
                applicationRequestDto.passportNumber(),
                applicationRequestDto.amount(),
                applicationRequestDto.status()
        ));
    }
}
