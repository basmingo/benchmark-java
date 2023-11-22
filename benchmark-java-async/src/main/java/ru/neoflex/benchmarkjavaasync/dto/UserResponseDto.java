package ru.neoflex.benchmarkjavaasync.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Optional;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserResponseDto {

    private Optional<UUID> uuid;

    private String name;

    @JsonProperty("last_name")
    private String lastName;

    private int age;

}
