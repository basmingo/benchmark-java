package ru.neoflex.benchmarkjavaasync.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Optional;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class ApplicationRequestDto {

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("email")
    private String email;

    @JsonProperty("amount")
    private BigDecimal amount;

    @JsonProperty("status")
    private Optional<String> status;
}
