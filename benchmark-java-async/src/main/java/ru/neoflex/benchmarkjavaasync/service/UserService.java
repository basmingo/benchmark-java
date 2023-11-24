package ru.neoflex.benchmarkjavaasync.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.neoflex.benchmarkjavaasync.dto.UserRequestDto;
import ru.neoflex.benchmarkjavaasync.dto.UserResponseDto;

import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class UserService {
    public Mono<String> processUser(UserRequestDto userRequestDto) {
        log.warn("accept user << {}", userRequestDto);
        UserResponseDto userResponseDto = new UserResponseDto();
        return Mono.just("Ok");
    }
}
