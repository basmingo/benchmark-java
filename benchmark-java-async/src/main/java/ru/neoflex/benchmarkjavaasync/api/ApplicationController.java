package ru.neoflex.benchmarkjavaasync.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import ru.neoflex.benchmarkjavaasync.core.model.ApplicationResponse;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ApplicationController {

    private final ServiceAdapter applicationService;

    @PostMapping("users/create")
    public Mono<ApplicationResponse> postUser(@RequestBody ApplicationRequestDto userRequestDto) {
        return applicationService.process(userRequestDto);
    }
}
