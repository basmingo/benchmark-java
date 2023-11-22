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
    public Mono<UserResponseDto> processUser(UserRequestDto userRequestDto) {
        log.warn("accept user << {}", userRequestDto);
        UserResponseDto userResponseDto = new UserResponseDto();

        userResponseDto.setUuid(Optional.of(UUID.randomUUID()));
        userResponseDto.setName(userResponseDto.getName());
        userResponseDto.setLastName(userResponseDto.getLastName());
        userResponseDto.setAge(userResponseDto.getAge());

        return Mono.just(userResponseDto);
    }

    public Mono<UserRequestDto> processPassport(UserRequestDto userRequestDto) {
        log.warn("accept passport << {} : {}", userRequestDto.getPassportSerialNumber(), userRequestDto.getPassportNumber());
        return Mono.just(userRequestDto);
    }
}
