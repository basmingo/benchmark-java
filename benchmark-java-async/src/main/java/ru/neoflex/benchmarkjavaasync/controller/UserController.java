package ru.neoflex.benchmarkjavaasync.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import ru.neoflex.benchmarkjavaasync.dto.UserRequestDto;
import ru.neoflex.benchmarkjavaasync.service.LogService;
import ru.neoflex.benchmarkjavaasync.service.UserService;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    private final LogService logService;

    @PostMapping("users/create")
    public Mono<UUID> postUser(@RequestBody UserRequestDto userRequestDto) {
        return userService.processUser(userRequestDto)
                .flatMap(ignore -> userService.processPassport(userRequestDto))
                .flatMap(ignore -> logService.processInformation(userRequestDto));
    }
}
