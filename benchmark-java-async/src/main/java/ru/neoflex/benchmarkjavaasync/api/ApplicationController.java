package ru.neoflex.benchmarkjavaasync.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import ru.neoflex.benchmarkjavaasync.impl.ApplicationServiceImpl;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ApplicationController {

    private final ApplicationServiceImpl userService;

    @PostMapping("users/create")
    public Mono<UUID> postUser(@RequestBody ApplicationRequestDto userRequestDto) {
        return null;
    }
}
