package ru.neoflex.benchmarkjavaasync.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.neoflex.benchmarkjavaasync.dto.UserRequestDto;

import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class LogService {

    public Mono<UUID> processInformation(UserRequestDto userRequestDto) {
        log.warn("process object : {}", userRequestDto.getUuid());

        return Mono.just(userRequestDto.getUuid().get())
                .onErrorComplete();
    }
}
